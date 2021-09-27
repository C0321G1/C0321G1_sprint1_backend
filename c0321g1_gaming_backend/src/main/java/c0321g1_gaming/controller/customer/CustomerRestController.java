package c0321g1_gaming.controller.customer;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.dto.customer.CusUDto;
import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.address.CommuneService;
import c0321g1_gaming.model.service.address.DistrictService;
import c0321g1_gaming.model.service.address.ProvinceService;
import c0321g1_gaming.model.service.category.CategoryService;
import c0321g1_gaming.model.service.customer.CustomerService;
import c0321g1_gaming.model.service.customer.CustomerStatusService;
import c0321g1_gaming.model.service.gender.GenderService;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CustomerRestController {
    @Autowired
    GenderService genderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    CommuneService communeService;

    @Autowired
    CustomerStatusService customerStatusService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CategoryService categoryService;

    //creator: vinhdn
    //creator: vinhdn
    @PostMapping("customer/signup")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        categoryService.createCategory();
        List<Category> categories = categoryService.findAll();

        accountService.saveAccount(customer.getAccount().getUsername(),
                customer.getAccount().getPassword(),
                categories.get(categories.size()-1).getCategoryId());
        List<Account> accountList = accountService.findAll();
        customer.getAccount().setAccountId(accountList.get(accountList.size()-1).getAccountId());

        accountService.saveRole(customer.getAccount().getAccountId(), (long) 1);

        if (customer.getAddress().getProvince() == null &&
                customer.getAddress().getDistrict() == null &&
                customer.getAddress().getCommune() == null) {
            Address address = new Address();
            addressService.save(address);
            List<Address> addressList = addressService.getAddressList();
            customer.getAddress().setAddressId(addressList.get(addressList.size()-1).getAddressId());
        } else {
            addressService.save(customer.getAddress());
            List<Address> addressList = addressService.getAddressList();
            customer.getAddress().setAddressId(addressList.get(addressList.size()-1).getAddressId());
        }

        customer.setFlag(0);

        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //creator: vinhdn
    @PostMapping("/customer/checkUsername")
    public ResponseEntity<Account> checkUsername(@RequestBody Account account) {
        Optional<Account> accountOptional = accountService.
                findByUsername(account.getUsername());
        if (accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Method : getAll Address,Province,District,Commune,gender,createNewCus,editCus
     * Author: Dong
     **/

    @GetMapping("/customer/customerStatus")
    public ResponseEntity<List<CustomerStatus>> getAllCustomerStatus() {
        List<CustomerStatus> customerStatusList = customerStatusService.getAllCustomerStatus();
        if (customerStatusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerStatusList, HttpStatus.OK);
    }

    @GetMapping("/customer/address")
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> addressList = addressService.getAddressList();
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/customer/province")
    public ResponseEntity<List<Province>> getAllProvince() {
        List<Province> provinceList = provinceService.getProvinceList();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

//    @GetMapping("/customer/district")
//    public ResponseEntity<List<District>> getAllDistrict() {
//        List<District> districtList = districtService.getDistrictList();
//        if (districtList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(districtList, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/customer/commune")
//    public ResponseEntity<List<Commune>> getAllCommune() {
//        List<Commune> communeList = communeService.getCommuneList();
//        if (communeList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(communeList, HttpStatus.OK);
//    }

    @GetMapping("/customer/gender")
    public ResponseEntity<List<c0321g1_gaming.model.entity.gender.Gender>> getAllGender() {
        List<c0321g1_gaming.model.entity.gender.Gender> genderList = genderService.getGenderList();
        if (genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @PatchMapping("/customer/edit")
    public ResponseEntity<Customer> editCusDto(@RequestBody CusDTO cusDTO) {
        Long addressIdEdit = addressService.fileByAddressId(cusDTO.getAddress());
        System.out.println(addressIdEdit);
        if (addressIdEdit != 0) {
            cusDTO.getAddress().setAddressId(addressIdEdit);
        } else {
            addressService.saveAddress(cusDTO.getAddress());
            cusDTO.getAddress().setAddressId((long) (addressService.getAddressList().size()));
        }
        customerService.updateCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/customer/create")
    public ResponseEntity<Void> createNewCusDto(@RequestBody CusDTO cusDTO) {
        Long addressId = addressService.fileByAddressId(cusDTO.getAddress());
        System.out.println(addressId);
        if (addressId != 0) {
            cusDTO.getAddress().setAddressId(addressId);
        } else {
            addressService.saveAddress(cusDTO.getAddress());
            cusDTO.getAddress().setAddressId((long) (addressService.getAddressList().size()));
        }
        customerService.saveCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public ResponseEntity<Customer> findByIdCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findByIdCustomerDb(customerId);
        if(customer!=null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Tung create get list customer
    @GetMapping("/customer/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.getListCustomer(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Tung create method search Employee
    @GetMapping("customer/search")
    public ResponseEntity<Page<Customer>> getSearchCustomer(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String account,
                                                            @RequestParam(defaultValue = "1900-01-01") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "2100-01-01") String dateBirthTo,
                                                            @RequestParam(defaultValue = "")String status,
                                                            @RequestParam(defaultValue = "")String province ) {
        Page<Customer> customers = customerService.searchCustomer(pageable,account,status,province,dateBirthFrom,dateBirthTo);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //vu
    @PatchMapping("/customer/edit-account")
    public ResponseEntity<Customer> editCusUDto(@RequestBody CusUDto cusUDto) {
        customerService.editCusUDto(cusUDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //vu code

    @GetMapping("/customer/account/{id}")
    @ResponseBody
    public ResponseEntity<Customer> findByIdAccount(@PathVariable("id") Long accountId) {
        if (accountId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findByIdAccount(accountId);
        if(customer!=null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

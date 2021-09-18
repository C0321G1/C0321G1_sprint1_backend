package c0321g1_gaming.controller.customer;
import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.address.CommuneService;
import c0321g1_gaming.model.service.address.DistrictService;
import c0321g1_gaming.model.service.address.ProvinceService;
import c0321g1_gaming.model.service.customer.CustomerService;
import c0321g1_gaming.model.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;
    @Autowired
    GenderService genderService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    DistrictService districtService;
    @Autowired
    CommuneService communeService;


    /**
     * Method : getAll Address,Province,District,Commune,gender,createNewCus,editCus
     * Author: Dong
     **/

    @GetMapping("/customer/address")
    public ResponseEntity<List<
            Address>> getAllAddress() {
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

    @GetMapping("/customer/district")
    public ResponseEntity<List<District>> getAllDistrict() {
        List<District> districtList = districtService.getDistrictList();
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/commune")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.getCommuneList();
        if (communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }

    @GetMapping("/customer/gender")
    public ResponseEntity<List<Gender>> getAllGender() {
        List<Gender> genderList = genderService.getGenderList();
        if (genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @PatchMapping("/customer/edit")
    public ResponseEntity<Customer> editCusDto(@RequestBody CusDTO cusDTO) {
        customerService.updateCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/customer/create")
    public ResponseEntity<Void> createNewCusDto(@RequestBody CusDTO cusDTO) {

        customerService.saveCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);
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
    // Tung create method delete customer
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Tung create method search Employee
    @GetMapping("/customer/search")
    public ResponseEntity<Page<Customer>> getSearchCustomer(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String account,
                                                            @RequestParam(defaultValue = "") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "") String dateBirthTo,
                                                            @RequestParam(defaultValue = "")String status,
                                                            @RequestParam(defaultValue = "")String province ) {
        Page<Customer> customers = customerService.searchCustomer(pageable,account,dateBirthFrom,dateBirthTo,status,province);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    GenderService genderService;
    @Autowired
    AddressService addressService;
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

    @GetMapping("/address")
    public ResponseEntity<List<
            Address>> getAllAddress() {
        List<Address> addressList = addressService.getAddressList();
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Province>> getAllProvince() {
        List<Province> provinceList = provinceService.getProvinceList();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> getAllDistrict() {
        List<District> districtList = districtService.getDistrictList();
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping(value = "/commune")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.getCommuneList();
        if (communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }

    @GetMapping("/gender")
    public ResponseEntity<List<Gender>> getAllGender() {
        List<Gender> genderList = genderService.getGenderList();
        if (genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Customer> editCusDto(@RequestBody CusDTO cusDTO) {
        customerService.updateCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
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

    // Tung create method search Employee.
    @GetMapping("customer/search")
    public ResponseEntity<Page<Customer>> getSearchCustomer(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String fullName,
                                                            @RequestParam(defaultValue = "") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "") String dateBirthTo,
                                                            @RequestParam(defaultValue = "") String status,
                                                            @RequestParam(defaultValue = "") String province) {
        Page<Customer> customers = customerService.searchCustomer(pageable, fullName, dateBirthFrom, dateBirthTo, status, province);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

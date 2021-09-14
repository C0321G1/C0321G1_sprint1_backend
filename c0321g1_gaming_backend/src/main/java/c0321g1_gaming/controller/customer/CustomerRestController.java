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
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> addressList = addressService.findAll();
        if (addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Province>> getAllProvince() {
        List<Province> provinceList = provinceService.findAll();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> getAllDistrict() {
        List<District> districtList = districtService.findAll();
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping(value = "/commune")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.findAll();
        if (communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }

    @GetMapping("/gender")
    public ResponseEntity<List<Gender>> getAllGender() {
        List<Gender> genderList = genderService.findAll();
        if (genderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(genderList, HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Customer> editCusDto(@RequestBody CusDTO cusDTO  ) {
            customerService.updateCusDto(cusDTO);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewCusDto(@RequestBody CusDTO cusDTO) {

        customerService.saveCusDto(cusDTO);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}

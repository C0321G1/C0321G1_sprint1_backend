package c0321g1_gaming.controller.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.address.CommuneService;
import c0321g1_gaming.model.service.address.DistrictService;
import c0321g1_gaming.model.service.address.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    DistrictService districtService;
    @Autowired
    CommuneService communeService;


    /**
     * Method : getAll Address,Province,District,Commune.
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

    @GetMapping("/commune")
    public ResponseEntity<List<Commune>> getAllCommune() {
        List<Commune> communeList = communeService.findAll();
        if (communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }
}

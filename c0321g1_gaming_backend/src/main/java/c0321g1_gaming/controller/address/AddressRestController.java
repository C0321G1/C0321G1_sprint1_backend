package c0321g1_gaming.controller.address;

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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressRestController {

    @Autowired
    AddressService addressService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    CommuneService communeService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddressList() {
        List<Address> addressList = addressService.getAddressList();
        if(addressList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Province>> getProvinceList() {
        List<Province> provinceList = provinceService.getProvinceList();
        if(provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @GetMapping("/district")
    public ResponseEntity<List<District>> getDistrictList() {
        List<District> districtList = districtService.getDistrictList();
        if(districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping("/commune")
    public ResponseEntity<List<Commune>> getCommuneList() {
        List<Commune> communeList = communeService.getCommuneList();
        if(communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }
}

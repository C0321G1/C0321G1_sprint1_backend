package c0321g1_gaming.controller.address;

import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.service.address.CommuneService;
import c0321g1_gaming.model.service.address.DistrictService;
import c0321g1_gaming.model.service.address.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/address")
public class AddressRestController {
    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;
    //creator: vinhdn
    @Autowired
    CommuneService communeService;
    @GetMapping("/province")
    public ResponseEntity<Iterable<Province>> getProvinceList() {
        Iterable<Province> provinceList = provinceService.findAll();
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }
    //creator: vinhdn
    @GetMapping("/district")
    public ResponseEntity<Iterable<District>> getDistrictList() {
        Iterable<District> districtList = districtService.findAll();
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }
    //creator: vinhdn
    @GetMapping("/commune")
    public ResponseEntity<Iterable<Commune>> getCommuneList() {
        Iterable<Commune> communeList = communeService.findAll();
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }
}

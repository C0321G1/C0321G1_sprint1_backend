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

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AddressRestController {
    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;
    //creator: vinhdn
    @Autowired
    CommuneService communeService;

    //creator: vinhdn
    @GetMapping("/province")
    public ResponseEntity<List<Province>> getProvinceList() {
        List<Province> provinceList = provinceService.findAll();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    //creator: vinhdn
    @GetMapping("/district")
    public ResponseEntity<List<District>> getDistrictList() {
        List<District> districtList = districtService.findAll();
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    //creator: vinhdn
    @GetMapping("/commune")
    public ResponseEntity<List<Commune>> getCommuneList() {
        List<Commune> communeList = communeService.findAll();
        if (communeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(communeList, HttpStatus.OK);
    }
}

package c0321g1_gaming.controller.gender;

import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/gender")
public class GenderRestController {
    @Autowired
    private GenderService genderService;
    //creator: vinhdn
    @GetMapping
    public ResponseEntity<Iterable<Gender>> getGenderList() {
        Iterable<Gender> genders = genderService.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }
}

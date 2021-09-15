package c0321g1_gaming.controller.gender;

import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.service.gender.GenderService;
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
@RequestMapping("/gender")
public class GenderRestController {
    @Autowired
    private GenderService genderService;

    //creator: vinhdn
    @GetMapping
    public ResponseEntity<List<Gender>> getGenderList() {
        List<Gender> genders = genderService.findAll();
        if (genders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }
}

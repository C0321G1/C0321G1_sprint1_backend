package c0321g1_gaming.controller.services;

import c0321g1_gaming.model.entity.services.Unit;
import c0321g1_gaming.model.service.services.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/units")
public class UnitRestController {
    @Autowired
    IUnitService unitService;

    @GetMapping(value = "")
    public ResponseEntity<List<Unit>> getAllList(){
        List<Unit> units = unitService.findAll();
        if (units.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(units,HttpStatus.OK);
    }
}
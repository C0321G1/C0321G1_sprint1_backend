package c0321g1_gaming.controller.employee;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PositionRestController {

    @Autowired
    PositionService positionService;

    @GetMapping("/position")
    public ResponseEntity<List<Position>> getPositionList() {
        List<Position> positionList = positionService.getPositionList();
        if(positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }
}

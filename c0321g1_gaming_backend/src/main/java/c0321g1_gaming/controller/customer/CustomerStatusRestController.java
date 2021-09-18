package c0321g1_gaming.controller.customer;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.service.customer.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerStatusRestController {
    @Autowired
    StatusService statusService;

    @GetMapping("/status")
    public ResponseEntity<List<CustomerStatus>> getStatusList() {
        List<CustomerStatus> statusList = statusService.getStatusList();
        if(statusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }
}

package c0321g1_gaming.controller.customer;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.service.customer.CustomerStatusService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CustomerStatusRestController {
    @Autowired
    CustomerStatusService customerStatusService;

/**
 * method: getAll customerStatus
 * author:Dong
 */

    @GetMapping("/customerStatus")
    public ResponseEntity<List<CustomerStatus>> getAllCustomerStatus() {
        List<CustomerStatus> customerStatuses = customerStatusService.findAll();
        if (customerStatuses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerStatuses, HttpStatus.OK);
    }
}

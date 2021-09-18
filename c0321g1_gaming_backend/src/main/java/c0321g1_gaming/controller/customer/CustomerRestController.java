package c0321g1_gaming.controller.customer;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;

    // Tung create get list customer
    @GetMapping("/customer/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.getListCustomer(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    // Tung create method delete customer
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Tung create method search Employee
    @GetMapping("/customer/search")
    public ResponseEntity<Page<Customer>> getSearchCustomer(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String account,
                                                            @RequestParam(defaultValue = "") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "") String dateBirthTo,
                                                            @RequestParam(defaultValue = "")String status,
                                                            @RequestParam(defaultValue = "")String province ) {
        Page<Customer> customers = customerService.searchCustomer(pageable,account,dateBirthFrom,dateBirthTo,status,province);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

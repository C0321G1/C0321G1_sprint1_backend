package c0321g1_gaming.controller.customer;

import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.account.AccountService;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AddressService addressService;

    //creator: vinhdn
    @PostMapping("/create")
    public ResponseEntity<Customer> createAccount(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        accountService.save(customer.getAccount());
        addressService.save(customer.getAddress());
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

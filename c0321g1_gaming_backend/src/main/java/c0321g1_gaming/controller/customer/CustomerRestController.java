package c0321g1_gaming.controller.customer;

import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.customer.CustomerService;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        accountService.save(customer.getAccount());
        if (customer.getAddress().getProvince() == null &&
                customer.getAddress().getDistrict() == null &&
                customer.getAddress().getCommune() == null) {
            customer.setAddress(new Address());
        } else {
            addressService.save(customer.getAddress());
            List<Address> addressList = addressService.getAddressList();
            Address address = new Address();
            address.setAddressId((long) addressList.size());
            customer.setAddress(address);
        }

        customer.setFlag(0);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //creator: vinhdn
    @PostMapping("/checkUsername")
    public ResponseEntity<Account> checkUsername(@RequestBody Account account) {
        Optional<Account> accountOptional = accountService.
                findByUsername(account.getUsername());
        if (accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else return new ResponseEntity<>(HttpStatus.OK);
    }
}

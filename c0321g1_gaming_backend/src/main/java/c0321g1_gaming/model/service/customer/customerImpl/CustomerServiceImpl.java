package c0321g1_gaming.model.service.customer.customerImpl;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //    creator: vinhdn
    @Override
    public void save(Customer customer) {
        customerRepository.saveQuery(customer.getFullName(),
                customer.getDateOfBirth(), customer.getPhone(), customer.getAddress().getAddressId(),
                customer.getGender().getGenderId(), customer.getAccount().getAccountId(), customer.getFlag());
    }
}

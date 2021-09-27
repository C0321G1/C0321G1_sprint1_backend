package c0321g1_gaming.model.service.user_detail_service_impl;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.repository.employee.EmployeeRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //creator: Tra
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.err.println(customerRepository.findCustomerByEmail(username) !=null);
        if (customerRepository.findCustomerByEmail(username) !=null ) {
            Customer customer = customerRepository.findCustomerByEmail(username);
            username = customer.getAccount().getUsername();
        }else if (customerRepository.findCustomerByPhone(username) != null){
            Customer customer = customerRepository.findCustomerByPhone(username);
            username = customer.getAccount().getUsername();
        }else if (employeeRepository.findEmployeeByPhone(username) != null) {
            Employee employee = employeeRepository.findEmployeeByPhone(username);
            username = employee.getAccount().getUsername();
        }
        String finalUsername = username;
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + finalUsername));
        return UserDetailsImpl.build(account);
    }
}


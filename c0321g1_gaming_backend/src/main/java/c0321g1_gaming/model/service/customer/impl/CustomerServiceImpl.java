package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return customerRepository.getListCustomer(pageable);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Page<Customer> searchCustomer(Pageable pageable, String fullName, String dateBirthFrom, String dateBirthTo, String status, String province) {
        return customerRepository.searchCustomer( pageable, fullName, dateBirthFrom, dateBirthTo, status, province);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
}

package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import com.sun.tools.javac.jvm.Gen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    private static Customer customer = new Customer();

    @Override
    public Customer getCusByEmail(String email) {
        return customerRepository.getCusByEmail(email);
    }

    @Override
    public Customer getCusByPassword(String password) {
        return customerRepository.getCusByPassword(password);
    }

    @Override
    public Customer getCusByUsername(String username) {
        return customerRepository.getCusByUsername(username);
    }

    @Override
    public void updateCusDto(CusDTO cusDTO) {
        accountRepository.updateAccountDto(cusDTO.getPassword(),cusDTO.getUsername());
        customerRepository.updateCusDto(cusDTO.getFullName(),cusDTO.getEmail(),cusDTO.getDateOfBirth(),cusDTO.getPhone(),
                cusDTO.getAddressId(),cusDTO.getGenderId(),cusDTO.getCustomerStatusId(),cusDTO.getCustomerId());
    }

    @Override
    public void saveCusDto(CusDTO cusDTO) {
        accountRepository.saveAccountDto(cusDTO.getPassword(), cusDTO.getUsername());
        customerRepository.saveCusDto(cusDTO.getFullName(),cusDTO.getEmail(),cusDTO.getDateOfBirth(),cusDTO.getPhone(),
                cusDTO.getAddressId(),cusDTO.getGenderId(),cusDTO.getFlag(),cusDTO.getCustomerStatusId());
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}

package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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
        accountRepository.updateAccountDto(cusDTO.getPassword(), cusDTO.getUsername());
        customerRepository.updateCusDto(cusDTO.getFullName(), cusDTO.getEmail(), cusDTO.getDateOfBirth(), cusDTO.getPhone(),
                cusDTO.getAddressId(), cusDTO.getGenderId(), cusDTO.getCustomerStatusId(), cusDTO.getCustomerId(1));
    }

    @Override
    public void saveCusDto(CusDTO cusDTO) {
        accountRepository.saveAccountDto(cusDTO.getPassword(), cusDTO.getUsername());
        customerRepository.saveCusDto(cusDTO.getFullName(), cusDTO.getEmail(), cusDTO.getDateOfBirth(), cusDTO.getPhone(),
                cusDTO.getAddressId(), cusDTO.getGenderId(), cusDTO.getFlag(), cusDTO.getCustomerStatusId());
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return customerRepository.getListCustomer(pageable);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Page<Customer> searchCustomer(Pageable pageable, String account, String dateBirthFrom,
                                         String dateBirthTo, String status, String province) {
        return customerRepository.searchCustomer( pageable, account,
                dateBirthFrom, dateBirthTo, status, province);
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

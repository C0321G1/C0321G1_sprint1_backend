package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yaml.snakeyaml.representer.BaseRepresenter;

import javax.persistence.EntityTransaction;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    private static Customer customer = new Customer();

    @Autowired
    AddressRepository addressRepository;

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
                cusDTO.getAddress().getAddressId(), cusDTO.getGenderId(), cusDTO.getCustomerStatusId(), cusDTO.getCustomerId());
    }

    @Override
    public void saveCusDto(CusDTO cusDTO) {
        accountRepository.saveAccountDto(cusDTO.getPassword(), cusDTO.getUsername());
        cusDTO.setFlag(1);
        customerRepository.saveCusDto(cusDTO.getFullName(), cusDTO.getEmail(), cusDTO.getDateOfBirth(), cusDTO.getPhone(),
                cusDTO.getAddress().getAddressId(), cusDTO.getGenderId(), cusDTO.getFlag(), cusDTO.getCustomerStatusId());
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
    public Page<Customer> searchCustomer(Pageable pageable, String fullName, String dateBirthFrom, String dateBirthTo, String status, String province) {
        return customerRepository.searchCustomer(pageable, fullName, dateBirthFrom, dateBirthTo, status, province);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByIdCustomerDb(Long id) {
        return customerRepository.findByCustomer(id);
    }


}

package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.dto.customer.CusUDto;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.repository.customer.CustomerRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;
    private static Customer customer = new Customer();

    @Autowired
    AddressRepository addressRepository;

    //    creator: vinhdn
    @Override
    public void save(Customer customer) {
        customerRepository.saveQuery(customer.getFullName(),
                customer.getDateOfBirth(), customer.getPhone(), customer.getAddress().getAddressId(),
                customer.getGender().getGenderId(), customer.getAccount().getAccountId(), customer.getFlag(),4L);
    }


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
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(cusDTO.getAccount().getPassword());
        accountRepository.updateAccountDto(encodedPassword, cusDTO.getAccount().getUsername());

        customerRepository.updateCusDto(cusDTO.getFullName(), cusDTO.getEmail(), cusDTO.getDateOfBirth(), cusDTO.getPhone(),
                cusDTO.getAddress(), cusDTO.getGender(), cusDTO.getCustomerStatus(), cusDTO.getCustomerId());
    }

    @Override
    public void saveCusDto(CusDTO cusDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(cusDTO.getAccount().getPassword());
        accountRepository.saveAccountDto( cusDTO.getAccount().getUsername(),encodedPassword);
        cusDTO.setFlag(1);
        List<Account> accountList = accountRepository.getAccountList();

        customerRepository.saveCusDto(cusDTO.getFullName(), cusDTO.getEmail(), cusDTO.getDateOfBirth(), cusDTO.getPhone(),
                cusDTO.getAddress(), cusDTO.getGender(), cusDTO.getFlag(), cusDTO.getCustomerStatus(), (long) accountList.size());
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
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Page<Customer> searchCustomer(Pageable pageable, String fullName, String dateBirthFrom, String dateBirthTo, String status, String province) {
        return customerRepository.searchCustomer(pageable, fullName, dateBirthFrom, dateBirthTo, status, province);
    }



    @Override
    public Customer findByIdCustomerDb(Long customerId) {
        return customerRepository.findByCustomer(customerId);
    }

    /**
     *  vu code
     * @param cusUDto
     */

    @Override
    public void editCusUDto(CusUDto cusUDto) {

        customerRepository.editCusUDto(cusUDto.getFullName(),cusUDto.getEmail(),cusUDto.getDateOfBirth(),cusUDto.getPhone()
                ,cusUDto.getCustomerId());
        customerRepository.upAddress(cusUDto.getAddress().getCommune().getCommuneId(),
                cusUDto.getAddress().getDistrict().getDistrictId(),
                cusUDto.getAddress().getProvince().getProvinceId(),
                cusUDto.getAddress().getAddressId());
    }
    @Override
    public Customer findByIdAccount(Long id) {
        return customerRepository.findByAccount_AccountId(id);
    }


}

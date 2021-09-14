package c0321g1_gaming.model.service.customer;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.customer.Customer;

import java.util.List;


public interface CustomerService {
    Customer getCusByEmail(String email);
    Customer getCusByPassword(String password);
    Customer getCusByUsername(String username);
    void updateCusDto(CusDTO cusDTO);
    void saveCusDto(CusDTO cusDTO);
    List<Customer> findAll();
}

package c0321g1_gaming.model.service.customer;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.dto.customer.CusUDto;
import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    //    creator: vinhdn
    void save(Customer customer);

    Customer getCusByEmail(String email);

    Customer getCusByPassword(String password);

    Customer getCusByUsername(String username);

    void updateCusDto(CusDTO cusDTO);

    void saveCusDto(CusDTO cusDTO);

    List<Customer> findAll();

    Page<Customer> getListCustomer(Pageable pageable);

    void deleteCustomer(Long id);

    Page<Customer> searchCustomer(Pageable pageable, String account, String status, String province,
                                  String dateBirthFrom, String dateBirthTo);


    Customer  findByIdCustomerDb(Long customerId);

    /**
     * vu code
     * @param cusUDto
     */
    void editCusUDto(CusUDto cusUDto);
    Customer findByIdAccount(Long id);

}

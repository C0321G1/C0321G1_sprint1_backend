package c0321g1_gaming.model.service.customer;
import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.List;

public interface CustomerService {
    Page<Customer> getListCustomer(Pageable pageable);
    void deleteCustomer(int id);
    Page<Customer> searchCustomer(Pageable pageable, String account, String dateBirthFrom,
                                  String dateBirthTo, String status, String province);
    Customer getCusByEmail(String email);
    Customer getCusByPassword(String password);
    Customer getCusByUsername(String username);
    void updateCusDto(CusDTO cusDTO);
    void saveCusDto(CusDTO cusDTO);
    List<Customer> findAll();
    void saveCustomer(Customer customer);

    Optional<Customer> findById(Long id);
}

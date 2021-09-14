package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    // Tùng create query get list customer
    @Query(value= "select * from customer " +
            "where flag_delete = 0 ", nativeQuery = true)
    Page<Customer> getListCustomer(Pageable pageable);

    // Tùng create query delete customer
    @Transactional
    @Modifying
    @Query(value = "update customer " +
            "set flag_delete = 1 " +
            "where customer_id = ?1 ", nativeQuery = true)
    void deleteCustomer(int id);

    // Tùng create method query search customer
    @Query(value = "SELECT customer.customer_id, customer.code, customer.date_of_birth, customer.email," +
            "  customer.flag_delete, customer.fullName,customer.phone," +
            "  customer.account_id, customer.status_id" +
            "  customer.address_id, customer.gender_id" +
            "   FROM `employee` " +
            "join `status` on `customer`.status_id = `status`.status_id " +
            "join address on customer.address_id = address.address_id " +
            "join province on address.province_id = province.province_id " +
            "where customer.fullName like %?1% and (customer.date_of_birth between ?2 and ?3) " +
            "and status.name like %?4%" +
            "and province.name like %?5% and customer.flag_delete = 0", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable,String fullName, String dateBirthFrom,
                                  String dateBirthTo, String status, String province);

}

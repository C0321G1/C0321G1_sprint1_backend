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
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * author : Dong
     * method: getCusByEmail
     */
    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.email =?1", nativeQuery = true)
    Customer getCusByEmail(String email);

    /**
     * author : Dong
     * method: getCusByPassword
     */
    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.`password` =?1", nativeQuery = true)
    Customer getCusByPassword(String password);

    /**
     * author : Dong
     * method: getCusByUsername
     */
    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.`username` =?1", nativeQuery = true)
    Customer getCusByUsername(String username);

    /**
     * author : Dong
     * method: updateCusDto
     */
    @Modifying
    @Transactional
    @Query(value = "update customer c " +
            "set " +
            "c.full_name=?1, " +
            "c.email=?2, " +
            "c.date_of_birth=?3, " +
            "c.phone=?4, " +
            "c.address_id=?5, " +
            "c.gender_id=?6, " +
            "c.status_id=?7 " +
            "where customer_id=?8 ", nativeQuery = true)
    void updateCusDto(String fullName,
                      String email,
                      String dateOfBirth,
                      String phone,
                      Long addressId,
                      Long genderId,
                      Long customerStatusId,
                      Long customerId);

    /**
     * author : Dong
     * method: saveCusDto
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `customer`(`full_name`,`email`,`date_of_birth`,`phone`,`address_id`,`gender_id`,`flag`,`status_id`)" +
            " VALUES (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    void saveCusDto(String fullName,
                    String email,
                    String dateOfBirth,
                    String phone,
                    Long addressId,
                    Long genderId,
                    int flag,
                    Long customerStatusId);

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
    @Query(value = "SELECT * " +
            "FROM `customer` " +
            "            inner join `address` on `customer`.address_id = `address`.address_id " +
            "             inner join `customer_status` on `customer`.status_id = `customer_status`.customer_status_id " +
            "            inner join province on address.province_id = province.province_id " +
            "            inner join `account` on `account`.account_id = customer.account_id " +
            "            where `account`.username like %?1% and ( customer.date_of_birth between ?2 and  ?3 ) " +
            "            and `customer_status`.`name` like %?4% " +
            "            and province.`name` like %?5% and `customer`.flag = 0 ", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, String fullName, String dateBirthFrom,
                                  String dateBirthTo, String status, String province);

}

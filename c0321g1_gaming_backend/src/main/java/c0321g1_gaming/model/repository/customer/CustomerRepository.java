package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


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
}

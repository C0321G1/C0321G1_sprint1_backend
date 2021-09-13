package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * author : Dong
     * method: getCusByEmail,getCusByPassword,getCusByUsername
     */
    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.email =?1", nativeQuery = true)
    Customer getCusByEmail(String email);

    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.`password` =?1", nativeQuery = true)
    Customer getCusByPassword(String password);

    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.`username` =?1", nativeQuery = true)
    Customer getCusByUsername(String username);

    @Modifying
    @Query(value = "insert into customer(`code`,date_of_birth,email,flag,full_name,phone,address_id,status_id,gender_id)\n" +
            "values(?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
    @Transactional
    void saveCustomer(@Param("code") String code,
                      @Param("dateOfBirth") String dateOfBirth,
                      @Param("email") String email,
                      @Param("flag") String flag,
                      @Param("fullName") String fullName,
                      @Param("phone") String phone,
                      @Param("address") String address,
                      @Param("gender") String gender,
                      @Param("customerStatus") String customerStatus
                      );
}

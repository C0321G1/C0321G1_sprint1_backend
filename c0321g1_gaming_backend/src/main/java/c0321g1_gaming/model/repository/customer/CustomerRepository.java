package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `customer`(`full_name`,`date_of_birth`,`phone`,`address_id`,`gender_id`,account_id,flag)" +
            " VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void saveQuery(String fullName,
                   String dateOfBirth,
                   String phone,
                   Long addressId,
                   Long genderId,
                   Long accountId,
                   int flat);
}

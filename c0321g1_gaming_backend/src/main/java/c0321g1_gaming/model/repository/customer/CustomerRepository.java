package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `customer`(`full_name`,`date_of_birth`,`phone`,`address_id`,`gender_id`,account_id,flag,status_id)" +
            " VALUES (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    void saveQuery(String fullName,
                   String dateOfBirth,
                   String phone,
                   Long addressId,
                   Long genderId,
                   Long accountId,
                   int flat,
                   Long statusId);

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
                      Address address,
                      c0321g1_gaming.model.entity.gender.Gender gender,
                      CustomerStatus customerStatus,
                      Long customerId);

    /**
     * author : Dong
     * method: saveCusDto
     */
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO `customer`(`full_name`,`email`,`date_of_birth`,`phone`,`address_id`,`gender_id`,`flag`,`status_id`,`account_id`)" +
            " VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void saveCusDto(String fullName,
                    String email,
                    String dateOfBirth,
                    String phone,
                    Address addressId,
                    c0321g1_gaming.model.entity.gender.Gender genderId,
                    int flag,
                    CustomerStatus customerStatusId,Long accountId);


    // Tùng create query get list customer
    @Query(value = "select * from customer " +
            "where flag = 1 ", nativeQuery = true)
    Page<Customer> getListCustomer(Pageable pageable);

    // Tùng create query delete customer
    @Transactional
    @Modifying
    @Query(value = "update customer " +
            "set flag = 0 " +
            "where customer_id = ?1 ", nativeQuery = true)
    void deleteCustomer(Long id);

    // Tùng create method query search customer
    @Query(value = "SELECT customer.*,account.username,customer_status.*" +
            "   FROM `customer` " +
            "join `account` on `customer`.account_id = `account`.account_id " +
            "join `customer_status` on `customer`.status_id = `customer_status`.customer_status_id " +
            "join `address` on `address`.address_id = `customer`.address_id " +
            "join `province` on `address`.province_id = `province`.province_id " +
            "where account.username like %?1% and customer_status.name like %?2% and province.name like %?3% and (customer.date_of_birth between ?4 and ?5)", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, String account, String status, String province, String dateBirthFrom, String dateBirthTo);

    // Tung create method findCustomerById by id
    @Query(value = "select * from customer where customer.customer_id = ?1", nativeQuery = true)
    Optional<Customer> findCustomerById(Long id);


    @Query(value = " select * from customer join `account`  on customer.account_id = `account`.account_id  where customer.customer_id = ?1 ", nativeQuery = true)
    Customer findByCustomer(Long customerId);
    /**
     * vu code
     * @param fullName
     *
     */
    @Modifying
    @Transactional
    @Query(value = "update customer c " +
            "set " +
            "c.full_name=?1, " +
            "c.email=?2, " +
            "c.date_of_birth=?3, " +
            "c.phone=?4 " +
            "where customer_id=?5", nativeQuery = true)
    void editCusUDto(String fullName,
                     String email,
                     String dateOfBirth,
                     String phone,
                     Long customerId);
    @Modifying
    @Transactional
    @Query(value = "update address c " +
            "set " +
            "c.commune_id=?1, " +
            "c.district_id=?2, " +
            "c.province_id=?3 " +
            "where address_id=?4", nativeQuery = true)
    void upAddress(Long communeId,
                   Long districtId,
                   Long provinceId,
                   Long addressId );

    @Modifying
    @Transactional
    @Query(value = "select *\n" +
            "from customer c\n" +
            "where c.`accountId` =?1", nativeQuery = true)
    Customer getCusByAccount(Long accountId);

    Customer findByAccount_AccountId(Long id);

    Customer findCustomerByEmail(String email);

    Customer findCustomerByPhone(String phone);
}


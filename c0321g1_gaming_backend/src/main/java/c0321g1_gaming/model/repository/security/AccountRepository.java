package c0321g1_gaming.model.repository.security;

import c0321g1_gaming.model.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT into account (username,password,category_id) values (?1,?2,?3) ", nativeQuery = true)
    void saveQuery(String username, String password, Long category_id);

    @Transactional
    @Modifying
    @Query(value = "INSERT into user_roles (account_id,role_id) values (?1,?2) ", nativeQuery = true)
    void saveRole(Long account_id, Long role_id);

    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAccountList();

    @Query(value = "select * from account where account_id = ?1", nativeQuery = true)
    Optional<Account> findByIdQuery(Long id);

    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Optional<Account> findByUsernameQuery(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account set username = ?1, password = ?2 where account_id = ?3 ", nativeQuery = true)
    void editAccountQuery(String username, String password, Long id);

    //creator: Tra
    Optional<Account> findByUsername(String username);
    /**
     * Auhor: Dong
     * method: saveAccountDto,updateAccountDto
     */

    @Modifying
    @Transactional
    @Query(value="INSERT INTO `account`(`username`,`password`) VALUES(?1,?2)",nativeQuery = true)
    void saveAccountDto(String username,String password);

    @Modifying
    @Transactional
    @Query(value="update `account` set `password` = ?1 where `username`= ?2 ",nativeQuery = true)
    void updateAccountDto(String password,String username);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO address (province_id, district_id, commune_id)" +
            "VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveAddress(Long provinceId, Long districtId, Long communeId);

    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Account findByUserNames(String userName);
}

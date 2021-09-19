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
    @Query(value = "INSERT into account (username,password) values (?1,?2) ", nativeQuery = true)
    void saveQuery(String username, String password);

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

}
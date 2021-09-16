package c0321g1_gaming.model.repository.account;

import c0321g1_gaming.model.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //creator: vinhdn
    @Modifying
    @Transactional
    @Query(value = "INSERT into account (username,password) values (?1,?2) ", nativeQuery = true)
    void saveQuery(String username, String password);

    //creator: vinhdn
    @Query(value = "select * from account", nativeQuery = true)
    List<Account> findAllQuery();

    //creator: vinhdn
    @Query(value = "select * from account where username = ?1", nativeQuery = true)
    Optional<Account> findByUsernameQuery(String username);

}

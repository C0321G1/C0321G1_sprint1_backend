package c0321g1_gaming.model.repository.account;

import c0321g1_gaming.model.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //creator: Tra
    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);

    //creator: vinhdn
    @Modifying
    @Transactional
    @Query(value = "UPDATE account set username = ?1, password = ?2 where account_id = ?3 ", nativeQuery = true)
    void editAccountQuery(String username, String password, Long id);

    //creator: vinhdn
    @Query(value = "select * from account", nativeQuery = true)
    List<Account> findAllQuery();
}

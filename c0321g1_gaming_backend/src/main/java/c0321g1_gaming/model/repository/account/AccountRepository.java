package c0321g1_gaming.model.repository.account;

import c0321g1_gaming.model.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //creator: Tra
    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);
}

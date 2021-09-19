package c0321g1_gaming.model.service.security;

import c0321g1_gaming.model.entity.security.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();

    Optional<Account> findById(Long id);

    Optional<Account> findByUsername(String username);

    void save(Account account);

    void saveAccount(String username, String password);

    void remove(Long id);

    void editAccount (String username,String password, Long id);

    boolean checkAccountExist(Account account);

    Long initAccountId(Account account);
}

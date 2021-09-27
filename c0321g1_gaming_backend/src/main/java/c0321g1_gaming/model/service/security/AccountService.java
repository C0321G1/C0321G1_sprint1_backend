package c0321g1_gaming.model.service.security;

import c0321g1_gaming.model.entity.security.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();

    Optional<Account> findById(Long id);

    Optional<Account> findByUsername(String username);

    void save(Account account);

    void saveAccount(String username, String password, Long category_id);

    void remove(Long id);

    void editAccount(String username, String password, Long id);

    boolean checkAccountExist(Account account);

    Long initAccountId(Account account);

    void saveRole(Long account_id, Long role_id);

    //vu code
    boolean checkPassword(Account account, String password);

    void setNewPassword(Account account, String newPassword);

    Account findByUsernames(String username);
}

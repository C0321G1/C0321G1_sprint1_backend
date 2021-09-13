package c0321g1_gaming.model.service.account;

import c0321g1_gaming.model.entity.security.Account;

import java.util.Optional;

public interface AccountService {
    //creator: vinhdn
    Iterable<Account> findALl();

    //creator: vinhdn
    Optional<Account> findById(Long id);

    //creator: vinhdn
    Optional<Account> findByUsername(String username);

    //creator: vinhdn
    void save(Account account);

    //creator: vinhdn
    void saveAccount(String username, String password);

    //creator: vinhdn
    void remove(Long id);

    //creator: vinhdn
    void editAccount(String username, String password, Long id);
}

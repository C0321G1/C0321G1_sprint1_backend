package c0321g1_gaming.model.service.account;

import c0321g1_gaming.model.entity.security.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    //creator: vinhdn
    void save(Account account);

    //creator: vinhdn
    List<Account> findAllQuery();

    //creator: vinhdn
    Optional<Account> findByUsernameQuery(String username);
}

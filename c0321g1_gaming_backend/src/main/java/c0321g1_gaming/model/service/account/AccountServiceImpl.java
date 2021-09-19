package c0321g1_gaming.model.service.account;

import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    //creator: vinhdn
    @Autowired
    private AccountRepository accountRepository;

    //creator: vinhdn
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    //creator: vinhdn
    @Override
    public List<Account> findAllQuery() {
        return accountRepository.findAllQuery();
    }

    //creator: vinhdn
    @Override
    public Optional<Account> findByUsernameQuery(String username) {
        return accountRepository.findByUsernameQuery(username);

    }

}

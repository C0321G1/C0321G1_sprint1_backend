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
    public Iterable<Account> findALl() {
        return accountRepository.findAll();
    }

    //creator: vinhdn
    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findByIdQuery(id);
    }

    //creator: vinhdn
    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsernameQuery(username);
    }

    //creator: vinhdn
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    //creator: vinhdn
    @Override
    public void saveAccount(String username, String password) {
        accountRepository.saveQuery(username, password);
    }

    //creator: vinhdn
    @Override
    public void remove(Long id) {
        accountRepository.delete(accountRepository.findById(id).get());
    }

    //creator: vinhdn
    @Override
    public void editAccount(String username, String password, Long id) {
        accountRepository.editAccountQuery(username, password, id);
    }
    //creator: vinhdn
    @Override
    public List<Account> findAllQuery() {
        return accountRepository.findAllQuery();
    }

}

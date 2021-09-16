package c0321g1_gaming.model.service.security.impl;

import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findByIdQuery(id);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsernameQuery(username);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void saveAccount(String username, String password) {
        accountRepository.saveQuery(username, password);
    }

    @Override
    public void remove(Long id) {
        accountRepository.delete(accountRepository.findById(id).get());
    }

    @Override
    public void editAccount(String username, String password, Long id) {
        accountRepository.editAccountQuery(username, password, id);
    }

    @Override
    public boolean checkAccountExist(Account account) {
        List<Account> accountList = accountRepository.findAll();
        for (Account value: accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Long initAccountId(Account account) {
        List<Account> accountList = accountRepository.findAll();
        for (Account value: accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return value.getAccountId();
            }
        }
        return null;
    }
}
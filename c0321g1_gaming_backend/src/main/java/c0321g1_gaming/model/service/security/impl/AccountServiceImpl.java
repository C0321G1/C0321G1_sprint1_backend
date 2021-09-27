package c0321g1_gaming.model.service.security.impl;

import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    public void saveAccount(String username, String password, Long category_id) {
        String passwordEncode = passwordEncoder.encode(password);
        accountRepository.saveQuery(username, passwordEncode, category_id);
    }

    @Override
    public void remove(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = new Account();
        if (accountOptional.isPresent()) {
            account = accountOptional.get();
        }
        accountRepository.delete(account);
    }

    @Override
    public void editAccount(String username, String password, Long id) {
        accountRepository.editAccountQuery(username, password, id);
    }

    @Override
    public boolean checkAccountExist(Account account) {
        List<Account> accountList = accountRepository.findAll();
        for (Account value : accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Long initAccountId(Account account) {
        List<Account> accountList = accountRepository.findAll();
        for (Account value : accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return value.getAccountId();
            }
        }
        return null;
    }

    @Override
    public void saveRole(Long account_id, Long role_id) {
        accountRepository.saveRole(account_id, role_id);
    }

    @Override
    public boolean checkPassword(Account account, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, account.getPassword());
    }

    @Override
    public void setNewPassword(Account account, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        account.setPassword(passwordEncoder.encode(newPassword));
        save(account);
    }
    @Override
    public Account findByUsernames(String username) {
        return this.accountRepository.findByUserNames(username);
    }
}
package c0321g1_gaming.controller.security;

import c0321g1_gaming.dto.security.AccountDto;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.account.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    //creator: vinhdn
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.saveAccount(account.getUsername(), account.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //creator: vinhdn
    @GetMapping("/id/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            accountService.save(accountOptional.get());
            return new ResponseEntity<>(accountOptional.get(), HttpStatus.OK);
        }
    }
    //creator: vinhdn
    @GetMapping("/username/{username}")
    public ResponseEntity<Account> findByUsername(@PathVariable String username) {
        Optional<Account> accountOptional = accountService.findByUsername(username);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            accountService.save(accountOptional.get());
            return new ResponseEntity<>(accountOptional.get(), HttpStatus.OK);
        }
    }
    //creator: vinhdn
    @PostMapping("/edit")
    public ResponseEntity<Account> editAccount(@RequestBody Account account) {
        accountService.editAccount(account.getUsername(), account.getPassword(), account.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

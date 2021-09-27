package c0321g1_gaming.controller.security;

import c0321g1_gaming.dto.security.AccountDto;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AccountRestController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAccountList() {
        List<Account> accountList = accountService.findAll();
        if(accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping("/account/{username}")
    public ResponseEntity<Account> getAccountByUserName(@PathVariable(name = "username") String username) {
        accountService.findByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Account> editAccount(@RequestBody AccountDto accountDto) {
        accountService.editAccount(accountDto.getUsername(), accountDto.getPassword(), accountDto.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //vu code
    @PostMapping("/account/getPass/{username}/{password}")
    public ResponseEntity<Boolean> checkPassword(@PathVariable(name = "username") String username,
                                                 @PathVariable(name = "password") String password) {
        Account account = accountService.findByUsernames(username);
        if (account == null) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        boolean match = accountService.checkPassword(account, password);
        if (match) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
    }
    //vucode
    @PostMapping("/account/setPass/{username}/{newPassword}")
    public ResponseEntity<Void> setNewPassword(@PathVariable(name = "username") String username,
                                               @PathVariable(name = "newPassword") String newPassword) {
        Account account = accountService.findByUsernames(username);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.setNewPassword(account, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

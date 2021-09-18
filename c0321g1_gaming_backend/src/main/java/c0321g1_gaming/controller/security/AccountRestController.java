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

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto) {
        accountService.saveAccount(accountDto.getUsername(), accountDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Account> editAccount(@RequestBody AccountDto accountDto) {
        accountService.editAccount(accountDto.getUsername(), accountDto.getPassword(), accountDto.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

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
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    //creator: vinhdn
    @GetMapping("/list")
    public ResponseEntity<List<Account>> getAccountList() {
        List<Account> accounts = accountService.findAllQuery();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}

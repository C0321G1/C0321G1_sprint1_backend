package c0321g1_gaming.controller;

import c0321g1_gaming.controller.security.AccountRestController;
import c0321g1_gaming.model.entity.security.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_getAccountList {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountRestController accountRestController;

    //creator: vinhdn
    @Test
    void getAccountList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/account/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    void getListStudent_6() {
        ResponseEntity<List<Account>> responseEntity
                = this.accountRestController.getAccountList();
        List<Account> accountList = responseEntity.getBody();

        int statusCode = responseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(6, accountList.size());
        Assertions.assertEquals(1, accountList.get(0).getAccountId());
        Assertions.assertEquals("test1", accountList.get(0).getUsername());
        Assertions.assertEquals("123", accountList.get(0).getPassword());
    }
}

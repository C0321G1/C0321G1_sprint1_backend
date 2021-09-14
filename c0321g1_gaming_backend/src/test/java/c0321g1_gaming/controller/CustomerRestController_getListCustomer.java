package c0321g1_gaming.controller;

import c0321g1_gaming.controller.customer.CustomerRestController;
import c0321g1_gaming.model.entity.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_getListCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRestController customerRestController;

    @Test
    public void getListCustomer_5() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListCustomer_6(){


        ResponseEntity<Page<Customer>> pageResponseEntity =
                this.customerRestController.getAllCustomer(PageRequest.of(0,5));

        Page<Customer> customerPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();
        Assertions.assertEquals(200,statusCode);
        Assertions.assertEquals(5,customerPage.getTotalElements());
        Assertions.assertEquals(1,customerPage.getTotalPages());
        Assertions.assertEquals(1,customerPage.getContent().get(0).getCustomerId());
        Assertions.assertEquals("Nguyễn Thanh Tùng",customerPage.getContent().get(0).getFullName());
        Assertions.assertEquals("KH-001",customerPage.getContent().get(0).getCode());
        Assertions.assertEquals("tung@gmail.com",customerPage.getContent().get(0).getEmail());
    }


}


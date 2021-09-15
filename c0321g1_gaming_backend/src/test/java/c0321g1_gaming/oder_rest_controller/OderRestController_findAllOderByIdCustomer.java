package c0321g1_gaming.oder_rest_controller;

import c0321g1_gaming.controller.order.OrderRestController;
import c0321g1_gaming.model.entity.order.Order;
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
//Huynh code
public class OderRestController_findAllOderByIdCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderRestController orderRestController;

    @Test
    public void findAllOderByIdCustomer_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order/{idCustomer}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllOderByIdCustomer_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order/{idCustomer}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllOderByIdCustomer_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order/{idCustomer}",100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllOderByIdCustomer_6() {
        ResponseEntity<Page<Order>> pageResponseEntity
                = this.orderRestController.findAllOderByCustomerId(
                PageRequest.of(0, 5), 1L);
        Page<Order> orderPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, orderPage.getTotalElements());
        Assertions.assertEquals(1, orderPage.getTotalPages());
        Assertions.assertEquals(1, orderPage.getContent().get(0).getOrderId());
        Assertions.assertEquals(1, orderPage.getContent().get(0).getStatus());
    }
}

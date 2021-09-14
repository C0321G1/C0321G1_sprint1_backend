package c0321g1_gaming.oder_rest_controller;

import c0321g1_gaming.controller.order.OrderRestController;
import c0321g1_gaming.model.service.order.IOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OderRestController_confirmPayment {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderRestController orderRestController;
    @Autowired
    private IOrderService orderService;

    @Test
    public void confirmPayment_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{id}", 100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_10() {
        ResponseEntity<Void> responseEntity = this.orderRestController.confirmPayment(1L);
        int statusCode = responseEntity.getStatusCodeValue();
        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(0, orderService.findById(1L).get().getStatus());
    }
}

package c0321g1_gaming.oder_rest_controller;

import c0321g1_gaming.controller_service.order.OrderRestController;
import c0321g1_gaming.model.service.order.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//Huynh code
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
                MockMvcRequestBuilders.patch("/order/{orderId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{orderId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{orderId}", 100))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void confirmPayment_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/order/{orderId}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

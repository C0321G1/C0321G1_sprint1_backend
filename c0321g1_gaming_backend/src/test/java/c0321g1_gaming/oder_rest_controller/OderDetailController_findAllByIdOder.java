package c0321g1_gaming.oder_rest_controller;

import c0321g1_gaming.controller.order.OrderDetailRestController;
import c0321g1_gaming.model.entity.order.OrderDetail;
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
public class OderDetailController_findAllByIdOder {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderDetailRestController orderDetailRestController;

    @Test
    public void findAllByIdOder_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order_detail/{idOder}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllByIdOder_12() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order_detail/{idOder}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllByIdOder_13() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order_detail/{idOder}",100L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllByIdOder_14() {
        ResponseEntity<List<OrderDetail>> listResponseEntity
                = this.orderDetailRestController.findAllOderDetailByOrderId(1L);
        List<OrderDetail> orderDetailList = listResponseEntity.getBody();
        int statusCode = listResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(2, orderDetailList.size());
        Assertions.assertEquals(1, orderDetailList.get(1).getQuantity());
        Assertions.assertEquals("pool", orderDetailList.get(1).getServices().getName());
        Assertions.assertEquals(10000, orderDetailList.get(1).getServices().getPrices());
    }
}

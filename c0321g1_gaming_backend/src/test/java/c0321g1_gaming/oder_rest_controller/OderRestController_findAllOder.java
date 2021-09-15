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
public class OderRestController_findAllOder{

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderRestController orderRestController;

    @Test
    //page size =0
    public void findAllOder_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/order/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findAllOder_2() {
        ResponseEntity<Page<Order>> pageResponseEntity
                = this.orderRestController.findAllOder(
                PageRequest.of(0, 5));
        Page<Order> oderPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(2, oderPage.getTotalElements());
        Assertions.assertEquals(1, oderPage.getTotalPages());
        Assertions.assertEquals(1, oderPage.getContent().get(0).getOrderId());
        Assertions.assertEquals(1, oderPage.getContent().get(0).getStatus());
    }
}

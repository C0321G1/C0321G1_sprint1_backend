package c0321g1_gaming.controller;


import c0321g1_gaming.dto.order.OrderDetailDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class OrderRestController_createOrderDetail {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void  createOrder_name_1() throws Exception {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderId(null);
        orderDetailDto.setQuantity(1);
        orderDetailDto.setTotalPrices(1);
        orderDetailDto.setServiceId((long) 1);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(orderDetailDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void  createOrder_name_2() throws Exception {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setServiceId((long) 1);
        orderDetailDto.setQuantity(1);
        orderDetailDto.setTotalPrices(1);
        orderDetailDto.setOrderId((long) 1);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(orderDetailDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}





















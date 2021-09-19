package c0321g1_gaming.controller;


import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.customer.Customer;
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
public class OrderRestController_createOrder {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void  createOrder_name_1() throws Exception {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(null);
        orderDto.setStatus(1);
        orderDto.setCustomerId((long) 1);
         this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(orderDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

 @Test
    public void  createOrder_name_2() throws Exception{
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId((long) 1);
        orderDto.setStatus(1);
     orderDto.setCustomerId((long) 1);
     this.mockMvc.perform(
             MockMvcRequestBuilders
                     .post("/create")
                     .contentType(MediaType.APPLICATION_JSON)
                     .content(this.objectMapper.writeValueAsString(orderDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}

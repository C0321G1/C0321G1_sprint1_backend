package c0321g1_gaming.controller;

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
public class CustomerRestController_deleteCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteCustomer_id_25() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete/{id}", "null"))
                .andDo(print()).andExpect(status().is4xxClientError());

    }

    @Test
    public void deleteCustomer_id_26() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete/{id}", ""))
                .andDo(print()).andExpect(status().is4xxClientError());

    }

//    @Test
//    public void deleteCustomer_id_27() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete/{id}", 10))
//                .andDo(print()).andExpect(status().is4xxClientError());
//
//    }

    @Test
    public void deleteCustomer_id_28() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/delete/{id}", 5))
                .andDo(print()).andExpect(status().is2xxSuccessful());

    }
}



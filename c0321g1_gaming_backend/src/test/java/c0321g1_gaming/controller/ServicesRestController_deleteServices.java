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
public class ServicesRestController_deleteServices {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteServices_id_25() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/services/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteServices_id_27() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/services/delete/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteServices_id_28() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/services/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

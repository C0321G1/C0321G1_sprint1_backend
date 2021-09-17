package c0321g1_gaming.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServicesRestController_findById {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findById_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/services/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/services/{id}", 30))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/services/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
//                .andExpect(jsonPath("$.servicesId").value(1));
//                .andExpect(jsonPath("$.name").value("nuoc loc"))
//                .andExpect(jsonPath("$.code").value("DV-0001"));
        //...
    }
}

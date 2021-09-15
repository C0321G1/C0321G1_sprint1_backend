package c0321g1_gaming.controller.category;

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
public class CategoryRestController_getCategory {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCategory_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/category/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCategory_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/category/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getCategory_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/category/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.description").value("1h 20.000 VND * số giờ chơi"))
                .andExpect(jsonPath("$.discount").value("10%"))
                .andExpect(jsonPath("$.type").value("Theo giờ"));
    }
}

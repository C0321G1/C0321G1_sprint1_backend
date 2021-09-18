package c0321g1_gaming;

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
public class EmployeeRestController_deleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    // khue write test case delete employee while id null
    @Test
    public void deleteEmployee_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case delete employee while id not found
    @Test
    public void deleteEmployee_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", 25))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case delete employee success
    @Test
    public void deleteEmployee_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

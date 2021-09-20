package c0321g1_gaming.controller;

import c0321g1_gaming.controller.computer.ComputerRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ComputerRestController_deleteComputer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ComputerRestController computerRestController;
    //Delete computer by id
    @Test
    public void deleteComputer_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/computer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteComputer_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/computer/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteComputer_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/computer/{id}", 8))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

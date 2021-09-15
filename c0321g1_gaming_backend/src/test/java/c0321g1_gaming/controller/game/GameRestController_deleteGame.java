package c0321g1_gaming.controller.game;

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
public class GameRestController_deleteGame {
//    Creator: Thúy
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteGame_id_25() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/game/api/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteGame_id_27() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/game/api/delete/{id}", 41))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteGame_id_28() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/game/api/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

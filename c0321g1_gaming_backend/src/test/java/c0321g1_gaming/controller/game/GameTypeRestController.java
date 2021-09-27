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
class GameTypeRestController {
    //    Creator: Nhung
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getListGameType_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/gameType/api"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getListGameType_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/gameType/api"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

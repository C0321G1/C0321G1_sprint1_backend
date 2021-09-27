package c0321g1_gaming.controller.game;

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
class GameRestController_findById {
    //    Creator: Thúy
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findById_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/game/api/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findById_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/game/api/{id}", 41))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findById_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/game/api/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.gameId").value(1))
                .andExpect(jsonPath("$.name").value("Pubg"))
                .andExpect(jsonPath("$.content").value("Đây là một trong những tựa game sinh tồn nổi tiếng nhất trên thế giới tính đến thời điểm hiện tại. Trò chơi này ban đầu dựa vào nền tảng của PlayerUnknown do Green thiết kế."))
                .andExpect(jsonPath("$.flagDelete").value("0"))
                .andExpect(jsonPath("$.image").value("https://img4.thuthuatphanmem.vn/uploads/2020/10/30/hinh-anh-pubg-dep_030927068.jpg"))
                .andExpect(jsonPath("$.gaming").value("20000"))
                .andExpect(jsonPath("$.trailer").value("https://www.youtube.com/embed/8ycrPEjBhIo"))
                .andExpect(jsonPath("$.gameType.name").value("Hành Động"));
    }
}

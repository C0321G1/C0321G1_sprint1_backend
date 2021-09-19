package c0321g1_gaming.controller.game;

import c0321g1_gaming.model.entity.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameRestController_searchGame {
    //    Creator: Thúy
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameRestController gameRestController;

    @Test
    void searchGame_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.
                        get("/employee/search?page=0&name=&gameType="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void searchGame_2() {
        ResponseEntity<Page<Game>> pageResponseEntity = this.gameRestController.searchGame(
                PageRequest.of(0, 8), "Pubg", "Hành Động");
        Page<Game> gamePage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, gamePage.getTotalElements());
        Assertions.assertEquals(1, gamePage.getTotalPages());
        Assertions.assertEquals(1, gamePage.getContent().get(0).getGameId());
        Assertions.assertEquals("Pubg", gamePage.getContent().get(0).getName());
        Assertions.assertEquals("Đây là một trong những tựa game sinh tồn nổi tiếng nhất trên thế giới tính đến thời điểm hiện tại. Trò chơi này ban đầu dựa vào nền tảng của PlayerUnknown do Green thiết kế.", gamePage.getContent().get(0).getContent());
        Assertions.assertEquals("https://img4.thuthuatphanmem.vn/uploads/2020/10/30/hinh-anh-pubg-dep_030927068.jpg", gamePage.getContent().get(0).getImage());
        Assertions.assertEquals("https://www.youtube.com/embed/8ycrPEjBhIo", gamePage.getContent().get(0).getTrailer());
        Assertions.assertEquals(0, gamePage.getContent().get(0).getFlagDelete());
        Assertions.assertEquals(20000, gamePage.getContent().get(0).getGaming());
        Assertions.assertEquals(1, gamePage.getContent().get(0).getGameType().getGameTypeId());
    }
}

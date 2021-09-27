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
class GameRestController_getListGame {
    //    Creator: Thúy
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameRestController gameRestController;

    @Test
    void getListGame_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/game/api"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getListStudent_6() {
        ResponseEntity<Page<Game>> pageResponseEntity
                = this.gameRestController.getListGame(
                PageRequest.of(0, 8));
        Page<Game> gamePage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(20, gamePage.getTotalElements());
        Assertions.assertEquals(3, gamePage.getTotalPages());
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

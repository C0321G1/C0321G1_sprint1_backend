package c0321g1_gaming.controller.game;

import c0321g1_gaming.dto.game.GameDto;
import c0321g1_gaming.model.entity.game.GameType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameRestController_editGame {
    //    Creator: Nhung
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findById_id_1() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/game/api/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_3() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/game/api/{id}", 77))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_4() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/game/api/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.gameId").value(2))
                .andExpect(jsonPath("$.name").value("Võ lâm truyền kỳ"))
                .andExpect(jsonPath("$.content").value("<p>võ lâm truyền kì</p>"))
                .andExpect(jsonPath("$.flagDelete").value(0))
                .andExpect(jsonPath("$.image").value("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f"))
                .andExpect(jsonPath("$.gaming").value("10000"))
                .andExpect(jsonPath("$.trailer").value("https://youtu.be/g-b2vjc1Y5Y"))
                .andExpect(jsonPath("$.gameType.gameTypeId").value(1));
    }


    @Test
    public void editGame_name_19() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName(null);
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_name_20() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_content_19() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent(null);
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_content_20() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void editGame_content_23() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>Võ lâm truyền kỳ [1] là một trò chơi nhập vai trực tuyến nhiều người chơi (MMORPG) được Việt hóa từ trò chơi Kiếm hiệp tình duyên Online (chữ Hán: 剑侠情缘; tiếng Anh: SWORDSMAN Online) của công ty Kingsoft (Kim Sơn) từ Trung Quốc và được VNG phân phối tại Việt Nam. Trò chơi cho phép các người chơi đóng vai dựa theo các tiểu thuyết kiếm hiệp của Trung Quốc. Trò chơi này từng gây cơn sốt ở Trung Quốc và được Hiệp hội Phần mềm Trung Quốc trao giải \"Trò chơi xuất sắc nhất năm 2003\"[2]\n" +
                "\n" +
                "Sau khi được Việt hóa giao diện và chuẩn bị các điều kiện cần thiết, trò chơi đã chính thức ra mắt người chơi Việt Nam vào ngày 21 tháng 3 năm 2005. Game đã thu hút được đông đảo người chơi từ rất nhiều ngành nghề: bác sĩ, giáo sư, giáo viên, học sinh, công nhân viên chức, nghệ sĩ nổi tiếng như: Ưng Hoàng Phúc, Tấn Beo, Lam Trường, Xuân Bắc, Ngân Khánh, …. Từ khi ra mắt năm 2005 đến thời điểm cập nhật 04/2014, VLTK đã có tổng cộng gần 20tr người chơi với 86 server trong một thời điểm[3]\n" +
                "\n" +
                "Một trong những hoạt động tầm cỡ, nổi bật nhất của Võ Lâm Truyền Kỳ là Đại hội Võ Lâm với sự tham gia của hơn 40.000 người vào năm 2005 tại nhà thi đấu Quân khu 7.[4]\n" +
                "\n" +
                "Ngoài các hoạt động trong game, Võ Lâm Truyền Kỳ còn tổ chức thành công cuộc thi Thập Đại Mỹ Nhân và các mỹ nhân đó hiện đang là những nhân vật nổi tiếng như ca sĩ Bảo Thy, diễn viên Ngân Khánh, ca sĩ Bích Ly, hoa hậu Ngọc Hân… Võ Lâm Truyền Kỳ Việt Nam đã trải qua 11 phiên bản. Phiên bản thứ 1 Công Thành Chiến, Phiên bản thứ 2 Sơn Hà Xã Tắc, Phiên bản thứ 3 Tình Nghĩa Giang Hồ, Phiên bản thứ 4 Phong Hỏa Liên Thành, Phiên bản thứ 5 Hùng Bá Thiên Hạ, phiên bản thứ 6 Thất Thành Đại Chiến, Phiên Bản thứ 7 Phong Vân Tái Khởi, Phiên bản thứ 8 Bát Mạch Chân Kinh, Phiên Bản thứ 9 Cửu Niên Trùng Phùng, Phiên bản thứ 10 Nơi Ta Thuộc Về, và trong năm 2015 ra mắt Phiên Bản thứ 11 Tụ Nghĩa Vi Minh.\n" +
                "\n" +
                "Ngoài Võ Lâm Truyền Kỳ I với 11 phiên bản trên, Võ Lâm Truyền Kỳ II cũng đã ra mắt vào năm 2007 và Võ Lâm Truyền Kỳ 3D ra mắt vào năm 2013. Trong năm 2014, song song việc nâng cấp lên phiên bản 10 Nơi Ta Thuộc Về, VNG cũng tái phát hành phiên bản Công Thành Chiến -Tình Trong Thiên Hạ, dành cho nhóm người chơi hoài niệm phiên bản cũ. Tuy nhiên, Võ Lâm Truyền Kỳ I, Võ Lâm Truyền Kỳ II và Võ Lâm Truyền Kỳ 3D là các trò chơi hoàn toàn khác biệt tuy đều được cung cấp bởi VNG.\n" +
                "\n" +
                "Năm 2016, phiên bản Mobile của tựa game Swordsman Mobile (JX Mobile) do Seasun Games sản xuất (thuộc Kingsoft) chính thức được phát hành ở Việt Nam với tên gọi \"Võ Lâm Truyền Kỳ Mobile\" do VNG phát hành, trở thành một trong những tựa game MMORPG hot ở thị trường Việt Nam. Hiện tựa game đã đạt hơn 25 triệu người và hơn 700 máy chủ của tựa game này. Năm 2021, Võ Lâm Truyền Kỳ 1 Mobile chính thức ra mắt. Tựa game được sản xuất bởi Seasun Games (thuộc Kingsoft) và VNG phát hành ở thị trường Việt Nam. Tựa game Võ Lâm Truyền Kỳ 1 Mobile được sản xuất dựa trên engine của tựa game Võ Lâm Truyền Kỳ I phiên bản PC nhằm đem đến cho người chơi những kí ức huyền thoại một thời, nhất là những người chơi lâu năm.\n" +
                "\n" +
                "Tại Trung Quốc, tựa game Swordsman Online (JX Online) được phát hành bởi nhà phát hành Xoyo (phiên bản PC) và Tencent Games (phiên bản Mobile). Vào năm 2019, Seasun Games (thuộc Kingsoft) đã sản xuất phiên bản HD Remake của tựa game JX3 Online, sử dụng engine tân tiến và DirectX 11, đem đến những trải nghiệm với chất lượng tốt nhất.</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_image_19() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage(null);
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_image_20() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",20)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_gaming_22() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(-7L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",20)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_trailer_19() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer(null);
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_trailer_20() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",20)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void editGame_24() throws Exception {
        GameDto gameDto = new GameDto();
        gameDto.setName("Võ lâm truyền kỳ");
        gameDto.setContent("<p>võ lâm truyền kì</p>");
        gameDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021115219PMvltk.png?alt=media&token=e18e0de3-f620-4499-b341-f282dc48f21f");
        gameDto.setGaming(10000L);
        gameDto.setTrailer("https://youtu.be/g-b2vjc1Y5Y");
        gameDto.setFlagDelete(0);
        GameType gameType = new GameType();
        gameType.setGameTypeId(1);
        gameDto.setGameType(gameType);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/game/api/{id}",2)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(gameDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}

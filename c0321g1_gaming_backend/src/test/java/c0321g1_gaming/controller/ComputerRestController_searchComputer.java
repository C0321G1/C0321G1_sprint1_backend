package c0321g1_gaming.controller;

import c0321g1_gaming.controller.computer.ComputerRestController;
import c0321g1_gaming.model.entity.computer.Computer;
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

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerRestController_searchComputer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ComputerRestController computerRestController;

    @Test
    public void searchComputer_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computer/searchComputer?computerId=&location=&computerType=ABCD&computerStatus=ACCB" +
                        "&startDateFrom=&startDateTo&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchComputer_2() {
        ResponseEntity<Page<Computer>> pageResponseEntity = this.computerRestController.searchComputer(
                PageRequest.of(0, 5), Optional.of("CP0001"), Optional.of("A1111"), Optional.of("Loai 1"),
                Optional.of("Đang sử dụng"), Optional.of(""), Optional.of(""));
        Page<Computer> computerPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, computerPage.getTotalElements());
        Assertions.assertEquals(1, computerPage.getTotalPages());
        Assertions.assertEquals("CP0001", computerPage.getContent().get(0).getComputerCode());
        Assertions.assertEquals("Đang sử dụng", computerPage.getContent().get(0).getComputerStatus().getName());
        Assertions.assertEquals("Loai 1", computerPage.getContent().get(0).getComputerType().getName());
        Assertions.assertEquals("Core I5, Ram 8G, SSD 512GB, Card RXT 3080", computerPage.getContent().get(0).getConfiguration());
    }
}

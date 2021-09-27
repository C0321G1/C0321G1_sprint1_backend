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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerRestController_getAllComputerPage {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ComputerRestController computerRestController;

    //Get all computer page
    @Test
    public void getAllComputerPage_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerPage"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllComputerPage_6() {
        ResponseEntity<Page<Computer>> pageResponseEntity
                = this.computerRestController.getAllComputerPage(
                PageRequest.of(0, 5));
        Page<Computer> computerPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(15, computerPage.getTotalElements());
        Assertions.assertEquals(3, computerPage.getTotalPages());
        Assertions.assertEquals(1, computerPage.getContent().get(0).getComputerId());
        Assertions.assertEquals("CP0001", computerPage.getContent().get(0).getComputerCode());
        Assertions.assertEquals("Đang sử dụng", computerPage.getContent().get(0).getComputerStatus().getName());
        Assertions.assertEquals("Loai 1", computerPage.getContent().get(0).getComputerType().getName());
    }

    //Get all computer manufacturer
    @Test
    public void getAllComputerManufacturer_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerManufacturer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllComputerManufacturer_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerManufacturer"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //get all computer type
    @Test
    public void getAllComputerType_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerType"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllComputerType_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerType"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //get all computer status
    @Test
    public void getAllComputerStatus_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerStatus"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getAllComputerStatus_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/computerStatus"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //Get computer by id
    @Test
    public void getComputer_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/computer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getComputer_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/computer/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getComputer_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/computer/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

package c0321g1_gaming.computerRestController;

import c0321g1_gaming.dto.computer.ComputerDto;
import c0321g1_gaming.dto.computer.ComputerManufacturerDto;
import c0321g1_gaming.dto.computer.ComputerStatusDto;
import c0321g1_gaming.dto.computer.ComputerTypeDto;
import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.entity.computer.ComputerType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComputerRestController_createComputer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createComputer_18() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1216");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
    @Test
    public void createComputer_ComputerCode_13() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode(null);
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createComputer_ComputerCode_14() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createComputer_ComputerCode_15() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CX5656");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createComputer_Location_15() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1617");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void createComputer_StartUsedDay_15() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1618");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-09-20");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createComputer_NameComputerType_15() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1619");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 99");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-09-16");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createComputer_Configuration_16() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1620");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb88888888888888888888888888888888888888888888");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-09-16");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createComputer_WarrantyPeriod_16() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1621");
        ComputerManufacturerDto computerManufacturerDto = new ComputerManufacturerDto();
        computerManufacturerDto.setComputerManufacturerId((long) 1);
        computerManufacturerDto.setName("Dell");
        computerDto.setComputerManufacturer(computerManufacturerDto);
        ComputerStatusDto computerStatusDto = new ComputerStatusDto();
        computerStatusDto.setComputerStatusId((long) 1);
        computerStatusDto.setName("Đang sử dụng");
        computerDto.setComputerStatus(computerStatusDto);
        ComputerTypeDto computerTypeDto = new ComputerTypeDto();
        computerTypeDto.setComputerTypeId((long) 1);
        computerTypeDto.setName("Loại 1");
        computerDto.setComputerType(computerTypeDto);
        computerDto.setConfiguration("I3, Ram 10Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-09-16");
        computerDto.setWarrantyPeriod("12 tháng 88888888888888888888888888888888888888888888");
        this.mockMvc.perform
                (MockMvcRequestBuilders.post("/create-computer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}

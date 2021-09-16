package c0321g1_gaming.computerRestController;

import c0321g1_gaming.dto.computer.ComputerDto;
import c0321g1_gaming.dto.computer.ComputerManufacturerDto;
import c0321g1_gaming.dto.computer.ComputerStatusDto;
import c0321g1_gaming.dto.computer.ComputerTypeDto;
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
public class ComputerRestController_updateComputer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateComputer_24() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP1258");
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
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void updateComputer_ComputerCode_19() throws Exception {
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
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_Configuration_20() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6907");
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
        computerDto.setConfiguration("");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_ComputerCode_21() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP690");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9090");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_Location_21() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A909");
        computerDto.setStartUsedDate("2021-02-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_StartUsedDate_21() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9096");
        computerDto.setStartUsedDate("2021-10-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateComputer_FlagDelete_21() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(5);
        computerDto.setLocation("A9096");
        computerDto.setStartUsedDate("2021-10-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_NameTypeComputer_21() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(5);
        computerDto.setLocation("A9096");
        computerDto.setStartUsedDate("2021-10-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_WarrantyPeriod_23() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9096");
        computerDto.setStartUsedDate("2021-10-02");
        computerDto.setWarrantyPeriod("12 tháng 88888888888888888888888888888888888888888888888");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateComputer_Configuration_23() throws Exception {
        ComputerDto computerDto = new ComputerDto();
        computerDto.setComputerCode("CP6904");
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
        computerDto.setConfiguration("I5 Ram 677Gb  88888888888888888888888888888888888888888888888");
        computerDto.setFlagDelete(0);
        computerDto.setLocation("A9096");
        computerDto.setStartUsedDate("2021-10-02");
        computerDto.setWarrantyPeriod("12 tháng");
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/update-computer/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON).content(this.objectMapper
                        .writeValueAsString(computerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

}

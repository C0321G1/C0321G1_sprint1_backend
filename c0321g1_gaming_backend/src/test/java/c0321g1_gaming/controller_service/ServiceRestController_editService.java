package c0321g1_gaming.controller_service;

import c0321g1_gaming.dto.services.ServicesDto;
import c0321g1_gaming.model.entity.services.Unit;
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
public class ServiceRestController_editService {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getInfoService_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/services/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getInfoServices_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/services/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void editService_name_13() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName(null);
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(12000);
        servicesDto.setQuantity(100);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editService_prices_13() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(0);
        servicesDto.setQuantity(100);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editService_quantity_13() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tiger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(12000);
        servicesDto.setQuantity(0);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editService_image_13() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tiger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(12000);
        servicesDto.setQuantity(100);
        servicesDto.setImage(null);

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editService_unit_13() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tiger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(12000);
        servicesDto.setQuantity(1000);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(0);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editService_price_15() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tiger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(999);
        servicesDto.setQuantity(100);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editService_quantity_15() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Tiger");
        servicesDto.setFlag(1);
        servicesDto.setCode("SV-9999");
        servicesDto.setPrices(1000);
        servicesDto.setQuantity(-4);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/services/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createStudent_name_18() throws Exception {
        ServicesDto servicesDto = new ServicesDto();
        servicesDto.setServicesId(13L);
        servicesDto.setName("Bia heniken");
        servicesDto.setPrices(12000);
        servicesDto.setQuantity(100);
        servicesDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/13-09-2021064426PMbo-huc.jpg?alt=media&token=356419bf-029f-4aae-84d2-24ff0a88958a");

        Unit unit = new Unit();
        unit.setUnitId(2);
        servicesDto.setUnit(unit);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/services/{id}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(servicesDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

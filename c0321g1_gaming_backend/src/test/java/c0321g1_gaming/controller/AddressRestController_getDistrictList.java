package c0321g1_gaming.controller;

import c0321g1_gaming.controller.address.AddressRestController;
import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressRestController_getDistrictList {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AddressRestController addressRestController;
    //creator: vinhdn
    @Test
    void getProvinceList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/address/district"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //creator: vinhdn
    @Test
    void getProvinceList_6() {
        ResponseEntity<List<District>> responseEntity
                = this.addressRestController.getDistrictList();
        List<District> districtList = responseEntity.getBody();

        int statusCode = responseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(2, districtList.size());
        Assertions.assertEquals(1, districtList.get(0).getDistrictId());
        Assertions.assertEquals("Hai Chau", districtList.get(0).getName());
    }
}

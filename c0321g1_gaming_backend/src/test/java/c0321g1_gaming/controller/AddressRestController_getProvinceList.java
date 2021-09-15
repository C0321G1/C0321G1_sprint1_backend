package c0321g1_gaming.controller;

import c0321g1_gaming.controller.address.AddressRestController;
import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.service.address.ProvinceService;
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
public class AddressRestController_getProvinceList {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AddressRestController addressRestController;
    //creator: vinhdn
    @Test
    public void getProvinceList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/address/province"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //creator: vinhdn
    @Test
    public void getProvinceList_6() {
        ResponseEntity<List<Province>> responseEntity
                = this.addressRestController.getProvinceList();
        List<Province> provinceList = responseEntity.getBody();

        int statusCode = responseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(2, provinceList.size());
        Assertions.assertEquals(1, provinceList.get(0).getProvinceId());
        Assertions.assertEquals("Da Nang", provinceList.get(0).getName());
    }
}

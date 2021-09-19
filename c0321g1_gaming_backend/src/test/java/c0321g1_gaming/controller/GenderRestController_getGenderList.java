package c0321g1_gaming.controller;

import c0321g1_gaming.controller.gender.GenderRestController;
import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.gender.Gender;
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
class GenderRestController_getGenderList {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private GenderRestController genderRestController;
    //creator: vinhdn
    @Test
    public void getGenderList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/gender"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //creator: vinhdn
    @Test
    void getGenderList_6() {
        ResponseEntity<List<Gender>> responseEntity
                = this.genderRestController.getGenderList();
        List<Gender> genderList = responseEntity.getBody();

        int statusCode = responseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(2, genderList.size());
        Assertions.assertEquals(1, genderList.get(0).getGenderId());
        Assertions.assertEquals("Nam", genderList.get(0).getName());
    }
}

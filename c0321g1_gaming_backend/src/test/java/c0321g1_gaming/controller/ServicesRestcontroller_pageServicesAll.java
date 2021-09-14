package c0321g1_gaming.controller;

import c0321g1_gaming.controller.services.ServicesRestController;
import c0321g1_gaming.model.entity.services.Services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServicesRestcontroller_pageServicesAll {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ServicesRestController servicesRestController;

    @Test
    public void pageServicesAll_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/services/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void pageServicesAll_6() {
        ResponseEntity<Page<Services>> pageResponseEntity
                = this.servicesRestController.pageServicesAll(
                PageRequest.of(0,1),Optional.of(""));
        Page<Services> servicesPage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
//        Assertions.assertEquals(1, servicesPage.getTotalElements());
//        Assertions.assertEquals(1, servicesPage.getTotalPages());
//        Assertions.assertEquals(1, servicesPage.getContent().get(0).getCode());
//        Assertions.assertEquals(1, servicesPage.getContent().get(0).getName());
        //...
    }
}

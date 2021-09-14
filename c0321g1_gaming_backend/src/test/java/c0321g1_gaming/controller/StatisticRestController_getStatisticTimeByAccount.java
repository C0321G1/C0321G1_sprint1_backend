package c0321g1_gaming.controller;

import c0321g1_gaming.controller.statistic.StatisticRestController;
import c0321g1_gaming.dto.statistic.StatisticByAccount;
import c0321g1_gaming.dto.statistic.StatisticByComputer;
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
public class StatisticRestController_getStatisticTimeByAccount {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StatisticRestController statisticRestController;
    @Test
    public void getStatisticTime_startTime_endTime_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-account/{startTime}/{endTime}","",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-account/{startTime}/{endTime}","null","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-account/{startTime}/{endTime}","2010-12-12","2021-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListStudent_6() {
        ResponseEntity<List<StatisticByAccount>> pageResponseEntity
                = this.statisticRestController.findStatisticByAccount("2010-12-12","2021-12-12");
        List<StatisticByAccount> statisticData = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();


        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(743, statisticData.get(0).getHour());
        Assertions.assertEquals("vipppp", statisticData.get(0).getAccount());
        //...
    }
}

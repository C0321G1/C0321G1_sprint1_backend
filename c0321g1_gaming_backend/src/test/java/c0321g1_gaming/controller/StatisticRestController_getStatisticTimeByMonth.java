package c0321g1_gaming.controller;

import c0321g1_gaming.controller.statistic.StatisticRestController;
import c0321g1_gaming.dto.statistic.StatisticByAccount;
import c0321g1_gaming.dto.statistic.StatisticByComputer;
import c0321g1_gaming.dto.statistic.StatisticByMonth;
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
public class StatisticRestController_getStatisticTimeByMonth {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StatisticRestController statisticRestController;
    @Test
    public void getStatisticTime_startTime_endTime_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-month/{startTime}/{endTime}","",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-month/{startTime}/{endTime}","null","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-month/{startTime}/{endTime}","2010-12-12","2021-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getListStudent_6() {
        ResponseEntity<List<StatisticByMonth>> pageResponseEntity
                = this.statisticRestController.findStatisticByMonth("2010-12-12","2021-12-12");
        List<StatisticByMonth> statisticData = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();


        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals("11/2020", statisticData.get(0).getMonth());
        Assertions.assertEquals(199000, statisticData.get(0).getService());
        Assertions.assertEquals(5000, statisticData.get(0).getComputer());
        Assertions.assertEquals(204000, statisticData.get(0).getTotal());
    }
}

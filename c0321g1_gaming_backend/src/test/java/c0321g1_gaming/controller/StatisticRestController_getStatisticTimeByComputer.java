package c0321g1_gaming.controller;

import c0321g1_gaming.controller.statistic.StatisticRestController;
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
public class StatisticRestController_getStatisticTimeByComputer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StatisticRestController statisticRestController;
    @Test
    public void getStatisticTime_startTime_endTime_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-computer/{startTime}/{endTime}","",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_2() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-computer/{startTime}/{endTime}","null","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStatisticTime_startTime_endTime_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-computer/{startTime}/{endTime}","2010-12-12","2021-12-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void getStatisticTime_startTime_endTime_4() {
        ResponseEntity<List<StatisticByComputer>> pageResponseEntity
                = this.statisticRestController.findStatisticByComputer("2010-12-12","2021-12-12");
        List<StatisticByComputer> statisticData = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();


        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(743, statisticData.get(0).getHour());
        Assertions.assertEquals("a1", statisticData.get(0).getComputer());
        //...
    }
    @Test
    public void getStatisticTime_startTime_after_endTime_1day() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/statistic/by-computer/{startTime}/{endTime}","2020-11-11","2020-11-10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

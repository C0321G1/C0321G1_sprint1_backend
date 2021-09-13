package c0321g1_gaming.controller.statistic;

import c0321g1_gaming.model.repository.statistic.StatisticRepository;
import c0321g1_gaming.model.service.statistic.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistic")
public class StatisticRestController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping("by-computer/{startTime}/{endTime}")
    public ResponseEntity<List<?>> findStatisticByComputer(@PathVariable String startTime, @PathVariable String endTime) {
        List<?> statisticByComputerList = statisticService.getStatisticByComputer(startTime,endTime);
        if (statisticByComputerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByComputerList, HttpStatus.OK);
    }

    @GetMapping("by-month/{startTime}/{endTime}")
    public ResponseEntity<List<?>> findStatisticByMonth(@PathVariable String startTime, @PathVariable String endTime) {
        List<?> statisticByMonthList = statisticService.getStatisticByMonth(startTime,endTime);
        if (statisticByMonthList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByMonthList, HttpStatus.OK);
    }

    @GetMapping("by-account/{startTime}/{endTime}")
    public ResponseEntity<List<?>> findStatisticByAccount(@PathVariable String startTime, @PathVariable String endTime) {
        List<?> statisticByAccountList = statisticService.getStatisticByMonth(startTime,endTime);
        if (statisticByAccountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(statisticByAccountList, HttpStatus.OK);
    }


}

package c0321g1_gaming.model.service.statistic;

import c0321g1_gaming.dto.order.OrderDetailDto;
import c0321g1_gaming.dto.statistic.StatisticByAccount;
import c0321g1_gaming.dto.statistic.StatisticByComputer;
import c0321g1_gaming.dto.statistic.StatisticByMonth;
import c0321g1_gaming.model.repository.statistic.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticImpl implements StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;


    @Override
    public List<StatisticByComputer> getStatisticByComputer(String startDate, String endDate) {
        return statisticRepository.getStatisticByComputer(startDate, endDate);
    }

    @Override
    public List<StatisticByMonth> getStatisticByMonth(String startDate, String endDate) {
        return statisticRepository.getStatisticByMonth(startDate, endDate);
    }

    @Override
    public List<StatisticByAccount> getStatisticByAccount(String startDate, String endDate) {
        return statisticRepository.getStatisticByAccount(startDate, endDate);
    }
}

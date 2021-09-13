package c0321g1_gaming.model.service.statistic;

import c0321g1_gaming.dto.order.OrderDetailDto;
import c0321g1_gaming.model.repository.statistic.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatisticImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;


    @Override
    public List<?> getStatisticByComputer(String startDate, String endDate) {
        return statisticRepository.getStatisticByComputer(startDate, endDate);
    }

    @Override
    public List<?> getStatisticByMonth(String startDate, String endDate) {
        return statisticRepository.getStatisticByMonth(startDate, endDate);
    }

    @Override
    public List<?> getStatisticByAccount(String startDate, String endDate) {
        return statisticRepository.getStatisticByAccount(startDate, endDate);
    }
}

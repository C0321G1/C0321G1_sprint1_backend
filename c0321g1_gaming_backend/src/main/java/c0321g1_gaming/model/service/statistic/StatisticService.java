package c0321g1_gaming.model.service.statistic;

import c0321g1_gaming.dto.order.OrderDetailDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticService {
    List<?> getStatisticByComputer(String startDate, String endDate);

    List<?> getStatisticByMonth(String startDate, String endDate);

    List<?> getStatisticByAccount(String startDate, String endDate);
}

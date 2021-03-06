package c0321g1_gaming.model.service.statistic;

import c0321g1_gaming.dto.statistic.StatisticByAccount;
import c0321g1_gaming.dto.statistic.StatisticByComputer;
import c0321g1_gaming.dto.statistic.StatisticByMonth;

import java.util.List;
// Create by HauHP
public interface StatisticService {
    List<StatisticByComputer> getStatisticByComputer(String startDate, String endDate);

    List<StatisticByMonth> getStatisticByMonth(String startDate, String endDate);

    List<StatisticByAccount> getStatisticByAccount(String startDate, String endDate);
}

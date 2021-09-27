package c0321g1_gaming.model.repository.statistic;

import c0321g1_gaming.dto.statistic.StatisticByAccount;
import c0321g1_gaming.dto.statistic.StatisticByComputer;
import c0321g1_gaming.dto.statistic.StatisticByMonth;
import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
// Create by HauHP
public interface StatisticRepository extends JpaRepository<OrderDetail, Long>{
    @Query(nativeQuery = true, value = "select sum(hour((timediff(start_time, end_time)))) as hour, computer_code as computer\n" +
            "from  order_detail \n" +
            "join `order` on `order`.order_id = order_detail.order_id\n" +
            "join customer on `order`.customer_id = customer.customer_id\n" +
            "join account on customer.account_id = account.account_id\n" +
            "join account_computer on account.account_id = account_computer.account_id\n" +
            "join computer on account_computer.computer_id = computer.computer_id\n" +
            "join category on account.category_id = category.category_id\n" +
            "where (start_time > date(:startDate)) and (end_time < date(:endDate))\n" +
            "group by computer;\n" )
    List<StatisticByComputer> getStatisticByComputer(String startDate, String endDate);

    @Query(nativeQuery = true,
            value = "select concat(month(start_time),'/',year(start_time)) as month, sum(total_prices) as service, sum(fee) as computer, (sum(total_prices) + sum(fee)) as total\n" +
                    "from order_detail\n" +
                    "join `order` on `order`.order_id = order_detail.order_id\n" +
                    "join customer on `order`.customer_id = customer.customer_id\n" +
                    "join account on customer.account_id = account.account_id\n" +
                    "join account_computer on account.account_id = account_computer.account_id\n" +
                    "join computer on account_computer.computer_id = computer.computer_id\n" +
                    "join category on account.category_id = category.category_id\n" +
                    "where (start_time > date(:startDate)) and (end_time < date(:endDate))\n" +
                    "group by month;")
    List<StatisticByMonth> getStatisticByMonth(String startDate, String endDate);

    @Query(nativeQuery = true, value = " select sum(hour((timediff(start_time, end_time)))) as hour, account.username as account\n" +
            "from order_detail\n" +
            "join `order` on `order`.order_id = order_detail.order_id\n" +
            "join customer on `order`.customer_id = customer.customer_id\n" +
            "join account on customer.account_id = account.account_id\n" +
            "join account_computer on account.account_id = account_computer.account_id\n" +
            "join computer on account_computer.computer_id = computer.computer_id\n" +
            "join category on account.category_id = category.category_id\n" +
            "where (start_time > date(:startDate)) and (end_time < date(:endDate))\n" +
            "group by account\n" +
            "order by hour \n" +
            "limit 10;")
    List<StatisticByAccount> getStatisticByAccount(String startDate, String endDate);
}
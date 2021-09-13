package c0321g1_gaming.model.repository.statistic;

import c0321g1_gaming.dto.order.OrderDetailDto;
import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
public interface StatisticRepository extends JpaRepository<OrderDetail, Long> {
    @Query(nativeQuery = true, value = "select sum(hour((timediff(start_time, end_time)))) as hour, computer_code as computer\n" +
            " from `order`\n" +
            "join customer on `order`.customer_id = customer.customer_id\n" +
            "join account on customer.account_id = account.account_id\n" +
            "join account_computer on account.account_id = account_computer.account_id\n" +
            "join computer on account_computer.computer_id = computer.computer_id\n" +
            "join category on account.category_id = category.category_id\n" +
            "where start_time > date(start_time) and end_time < date(end_time)\n" +
            "group by computer;")
    List<?> getStatisticByComputer(String startDate, String endDate);

    @Query(nativeQuery = true, value = "select month(start_time) as month, sum(total_prices) as money_service, sum(fee) as money_computer, (sum(total_prices) + sum(fee)) as total_money\n" +
            "from `order`\n" +
            "join customer on `order`.customer_id = customer.customer_id\n" +
            "join account on customer.account_id = account.account_id\n" +
            "join account_computer on account.account_id = account_computer.account_id\n" +
            "join computer on account_computer.computer_id = computer.computer_id\n" +
            "join category on account.category_id = category.category_id\n" +
            "where start_time > date(start_time) and end_time < date(end_time)\n" +
            "group by month;")
    List<?> getStatisticByMonth(String startDate, String endDate);

    @Query(nativeQuery = true, value = "select sum(hour((timediff(start_time, end_time)))) as hour, account.username as account\n" +
            "from `order`\n" +
            "join customer on `order`.customer_id = customer.customer_id\n" +
            "join account on customer.account_id = account.account_id\n" +
            "join account_computer on account.account_id = account_computer.account_id\n" +
            "join computer on account_computer.computer_id = computer.computer_id\n" +
            "join category on account.category_id = category.category_id\n" +
            "where start_time > date(start_time) and end_time < date(end_time)\n" +
            "group by account;")
    List<?> getStatisticByAccount(String startDate, String endDate);
}

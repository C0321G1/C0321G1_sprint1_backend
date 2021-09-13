package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {

     @Modifying
     @Query(value= " insert into orders(orders.cutomer_id, orders.quantity ,orders.prices, orders.total_prices, orders.service_id ,orders.unit_id)  value(?1, ?2, ?3, ?4, ?5, ?6);", nativeQuery = true)
    void createOrder();
}

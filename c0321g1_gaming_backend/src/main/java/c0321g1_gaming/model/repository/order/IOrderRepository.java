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
     @Query(value= " insert into orders(orders.cutomer_id,  orders.service_id, orders)  value(?1, ?2, ?3, ?4, ?5, ?6);", nativeQuery = true)
    void createOrder();
}

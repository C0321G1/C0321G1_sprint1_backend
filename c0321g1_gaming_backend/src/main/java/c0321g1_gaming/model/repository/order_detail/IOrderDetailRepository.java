package c0321g1_gaming.model.repository.order_detail;

import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
   @Transactional
    @Modifying
    @Query(value= " insert into order_detail(order_detail.quantity,  order_detail.total_prices, order_detail.services_id,order_detail.order_id)  value(?1, ?2, ?3 ?4);", nativeQuery = true)
    void createDetail(Long orderId, int quantity, int quantity1, int totalPrices, Long serviceId);
}

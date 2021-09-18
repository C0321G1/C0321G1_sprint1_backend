package c0321g1_gaming.model.repository.order_detail;

import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
   @Transactional
    @Modifying
    @Query(value= " INSERT INTO order_detail(quantity, total_prices, order_id, services_id)  VALUES (?1, ?2, ?3, ?4);", nativeQuery = true)
   void createDetail( int quantity, int totalPrices, Long orderId, Long serviceId);
    @Query(value = " select * from order_detail where order_id= :oderId", nativeQuery = true)
    List<OrderDetail> getAllOderDetailByOderId(@Param("oderId") Long oderId);


}

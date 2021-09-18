package c0321g1_gaming.model.repository.order_detail;


import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    //Huynh code

    @Query(value = " select * from order_detail where order_id= :oderId", nativeQuery = true)
    List<OrderDetail> getAllOderDetailByOderId(@Param("oderId") Long oderId);
}

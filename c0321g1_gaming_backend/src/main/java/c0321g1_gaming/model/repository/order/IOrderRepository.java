package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface IOrderRepository extends JpaRepository<Order, Long> {

    //Huynh code
    @Query(value = " select * from `order`", nativeQuery = true)
    Page<Order> pageOderAll(Pageable pageable);
    //Huynh code
    @Query(value = "select * " +
            "from `order` " +
            "where `order`.customer_id = :idCustomer", nativeQuery = true)
    Page<Order> pageOderByCustomer(Pageable pageable, @Param("idCustomer") Long idCustomer);

    //Huynh code
    @Query(value = "select * from `order` where order_id=:orderId"
            , nativeQuery = true)
    Optional<Order> findById(@Param("orderId") Long oderId);

}

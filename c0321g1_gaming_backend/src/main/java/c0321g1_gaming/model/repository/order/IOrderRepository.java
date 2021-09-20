package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IOrderRepository extends JpaRepository<Order, Long> {
    //vu code
    @Modifying
    @Transactional
    @Query(value = " insert into `order`(`order`.customer_id, `order`.status)  value(?1, ?2);", nativeQuery = true)
    void createOrder(Long customer_id, int status);

    @Query(value = "select max(order_id) from  `order` ", nativeQuery = true)
    Long maxIdOrder();


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
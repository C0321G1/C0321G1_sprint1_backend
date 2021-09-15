package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(value = " select * from order where status = 1", nativeQuery = true)
    Page<Order> pageOderAll(Pageable pageable);

    @Query(value = "select * " +
            "from order " +
            "where status=1 and order.customer_id = :idCustomer", nativeQuery = true)
    Page<Order> pageOderByCustomer(Pageable pageable, @Param("idCustomer") Long idCustomer);

    @Query(value = "update order set status=0 where order_id =:oderId"
            , nativeQuery = true)
    void updateConfirmPayment(@Param("oderId") Long oderId);

    @Query(value = "select * from order where status = 1 and order_id=:oderId"
            , nativeQuery = true)
    Optional<Order> findById(@Param("oderId") Long oderId);

}

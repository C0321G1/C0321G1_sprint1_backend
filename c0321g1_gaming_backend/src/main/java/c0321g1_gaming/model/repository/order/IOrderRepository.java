package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.model.entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = " select * from orders where status = 1", nativeQuery = true)
    Page<Orders> pageOderAll(Pageable pageable);

    @Query(value = "select * " +
            "from orders " +
            "where status=1 and orders.customer_id = :idCustomer", nativeQuery = true)
    Page<Orders> pageOderByCustomer(Pageable pageable, @Param("idCustomer") Long idCustomer);

    @Query(value = "update orders set status=0 where order_id =:oderId"
            , nativeQuery = true)
    void updateConfirmPayment(@Param("oderId") Long oderId);

    @Query(value = "select * from orders where status = 1 and order_id=:oderId"
            , nativeQuery = true)
    Optional<Orders> findById(@Param("oderId") Long oderId);

}

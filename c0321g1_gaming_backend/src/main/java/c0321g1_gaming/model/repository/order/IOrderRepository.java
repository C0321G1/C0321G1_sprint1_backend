package c0321g1_gaming.model.repository.order;

import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    //vu code
    @Modifying
    @Transactional
    @Query(value= " insert into `order`(`order`.customer_id, `order`.status)  value(?1, ?2);", nativeQuery = true)
    void createOrder(Long customer_id,int status);

}





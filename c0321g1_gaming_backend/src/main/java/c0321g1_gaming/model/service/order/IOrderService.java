package c0321g1_gaming.model.service.order;

import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {
    void create(Order order);
    //Huynh code
    Page<Order> findAllOder(Pageable pageable);
    //Huynh code
    Page<Order> findOderByIdCustomer(Pageable pageable, Long idCustomer);
    //Huynh code
    void confirmPayments(Long idOrders);
    //Huynh code
    Optional<Order> findById(Long id);
}

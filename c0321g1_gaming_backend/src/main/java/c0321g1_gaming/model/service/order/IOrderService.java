package c0321g1_gaming.model.service.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.order.Order;

import java.util.Optional;

public interface IOrderService {
    //vu code
    void create(OrderDto orderDto);

    void confirmPayments(Long idOrders);

    Optional<Order> findById(Long id);
     Long maxIdOrder();

}

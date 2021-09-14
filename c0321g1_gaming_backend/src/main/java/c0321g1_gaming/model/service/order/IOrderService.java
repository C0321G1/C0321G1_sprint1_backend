package c0321g1_gaming.model.service.order;

import c0321g1_gaming.dto.order.OrderDto;


import c0321g1_gaming.model.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {
    //vu code
    void create(OrderDto orderDto);

    Page<Order> findAllOder(Pageable pageable);

    Page<Order> findOderByIdCustomer(Pageable pageable,Long idCustomer);

    void confirmPayments(Long idOrders);

    Optional<Order> findById(Long id);
}

package c0321g1_gaming.model.service.order;

import c0321g1_gaming.model.entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrderService {
    void create(Orders order);

    Page<Orders> findAllOder(Pageable pageable);

    Page<Orders> findOderByIdCustomer(Pageable pageable,Long idCustomer);

    void confirmPayments(Long idOrders);

    Optional<Orders> findById(Long id);
}

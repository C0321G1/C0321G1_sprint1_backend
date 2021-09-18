package c0321g1_gaming.model.service.order;


import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    //vu code
    @Override
    public void create(OrderDto orderDto) {
        this.orderRepository.createOrder(
                orderDto.getCustomerId(),1
        );
    }

    @Override
    public void confirmPayments(Long idOrders) {

    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Long maxIdOrder() {
        return this.orderRepository.maxIdOrder();
    }

}



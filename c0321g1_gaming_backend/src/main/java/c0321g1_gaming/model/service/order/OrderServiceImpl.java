package c0321g1_gaming.model.service.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public void create(OrderDto orderDto) {
        this.orderRepository.createOrder(
                orderDto.getStatus(),
                orderDto.getCustomerId()
                );
    }
}

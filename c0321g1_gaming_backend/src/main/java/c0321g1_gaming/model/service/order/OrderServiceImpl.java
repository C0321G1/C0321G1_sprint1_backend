package c0321g1_gaming.model.service.order;

import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.repository.order.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    @Override
    public void create(Order order) {
    }

    @Override
    public Page<Order> findAllOder(Pageable pageable) {
        return orderRepository.pageOderAll(pageable);
    }

    @Override
    public Page<Order> findOderByIdCustomer(Pageable pageable, Long idCustomer) {
        return orderRepository.pageOderByCustomer(pageable, idCustomer);
    }

    @Override
    public void confirmPayments( Long idOrders) {
        orderRepository.updateConfirmPayment(idOrders);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }


}

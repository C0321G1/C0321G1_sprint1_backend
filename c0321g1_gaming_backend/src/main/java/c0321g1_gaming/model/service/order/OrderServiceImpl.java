package c0321g1_gaming.model.service.order;

import c0321g1_gaming.model.entity.order.Orders;
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
    public void create(Orders order) {
    }

    @Override
    public Page<Orders> findAllOder(Pageable pageable) {
        return orderRepository.pageOderAll(pageable);
    }

    @Override
    public Page<Orders> findOderByIdCustomer(Pageable pageable, Long idCustomer) {
        return orderRepository.pageOderByCustomer(pageable, idCustomer);
    }

    @Override
    public void confirmPayments( Long idOrders) {
        orderRepository.updateConfirmPayment(idOrders);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }


}

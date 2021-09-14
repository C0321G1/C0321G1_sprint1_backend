package c0321g1_gaming.model.service.order_detail;

import c0321g1_gaming.dto.order.OrderDetailDto;
import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.repository.order_detail.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public void createDetail(OrderDetailDto orderDetailDto) {
        this.orderDetailRepository.createDetail (
                orderDetailDto.getOrderId(),
                orderDetailDto.getQuantity(),
                orderDetailDto.getQuantity(),
                orderDetailDto.getTotalPrices(),
                orderDetailDto.getServiceId()
        );

    }
}

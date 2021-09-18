package c0321g1_gaming.model.service.order_detail;

import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.repository.order_detail.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;
     //vu code
    @Override
    public void createDetail(OrderDetail orderDetail) {
        this.orderDetailRepository.createDetail(
                orderDetail.getQuantity(),
                orderDetail.getTotalPrices(),
                orderDetail.getOrder().getOrderId(),
                orderDetail.getServices().getServicesId()
        );
    }


    @Override
    public List<OrderDetail> findAllOderDetailsByOderId(Long oderId) {
        return orderDetailRepository.getAllOderDetailByOderId(oderId);

    }
}
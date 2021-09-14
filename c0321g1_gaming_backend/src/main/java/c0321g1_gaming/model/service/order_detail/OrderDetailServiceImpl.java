package c0321g1_gaming.model.service.order_detail;

import c0321g1_gaming.model.entity.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Autowired
    IOrderDetailService orderDetailService;
    @Override
    public List<OrderDetail> findAllOderDetailsByOderId(Long oderId) {
        return orderDetailService.findAllOderDetailsByOderId(oderId);
    }
}

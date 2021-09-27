package c0321g1_gaming.model.service.order_detail;

import c0321g1_gaming.model.entity.order.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    //vu code
    void createDetail(OrderDetail orderDetail);

    //Huynh code

    List<OrderDetail> findAllOderDetailsByOderId(Long oderId);
}
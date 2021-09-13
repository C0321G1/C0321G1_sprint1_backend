package c0321g1_gaming.dto.order;

import c0321g1_gaming.model.entity.order.Orders;

import java.util.List;


public class OrderDetailDto {
    private Long orderDetailId;
    private List<Orders> ordersDtoList;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, List<Orders> ordersDtoList) {
        this.orderDetailId = orderDetailId;
        this.ordersDtoList = ordersDtoList;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public List<Orders> getOrdersDtoList() {
        return ordersDtoList;
    }

    public void setOrdersDtoList(List<Orders> ordersDtoList) {
        this.ordersDtoList = ordersDtoList;
    }
}

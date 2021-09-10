package c0321g1_gaming.dto.order;

import c0321g1_gaming.model.entity.order.Order;

import java.util.List;


public class OrderDetailDto {
    private Long orderDetailId;
    private List<Order> orderDtoList;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, List<Order> orderDtoList) {
        this.orderDetailId = orderDetailId;
        this.orderDtoList = orderDtoList;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public List<Order> getOrderDtoList() {
        return orderDtoList;
    }

    public void setOrderDtoList(List<Order> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }
}

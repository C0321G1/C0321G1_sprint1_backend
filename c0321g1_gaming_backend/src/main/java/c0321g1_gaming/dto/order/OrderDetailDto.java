package c0321g1_gaming.dto.order;

import c0321g1_gaming.model.entity.order.Order;

import java.util.List;


public class OrderDetailDto {
    private Long orderDetailId;
    private Order order;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, Order order) {
        this.orderDetailId = orderDetailId;
        this.order = order;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

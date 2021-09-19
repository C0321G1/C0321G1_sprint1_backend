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

<<<<<<< HEAD
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrices() {
        return totalPrices;
=======
    public List<Order> getOrderDtoList() {
        return orderDtoList;
>>>>>>> origin
    }

    public void setOrderDtoList(List<Order> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }
}

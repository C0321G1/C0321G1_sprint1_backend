package c0321g1_gaming.dto.order;

import c0321g1_gaming.model.entity.order.Orders;
import c0321g1_gaming.model.entity.services.Services;

import java.util.List;


public class OrderDetailDto {
    private Long orderDetailId;
    private Orders orders;
    private Services services;
    private int quantity;
    private int totalPrices;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, Orders orders, Services services, int quantity, int totalPrices) {
        this.orderDetailId = orderDetailId;
        this.orders = orders;
        this.services = services;
        this.quantity = quantity;
        this.totalPrices = totalPrices;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }
}

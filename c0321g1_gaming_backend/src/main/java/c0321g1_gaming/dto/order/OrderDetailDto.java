package c0321g1_gaming.dto.order;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.services.Services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetailDto {
    private Long orderDetailId;
    private Services services;
    private Order order;
    @NotNull
    @Min(1)
    private int quantity;
    private int totalPrices;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, Services services, Order order, @NotNull @Min(1) int quantity, int totalPrices) {
        this.orderDetailId = orderDetailId;
        this.services = services;
        this.order = order;
        this.quantity = quantity;
        this.totalPrices = totalPrices;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

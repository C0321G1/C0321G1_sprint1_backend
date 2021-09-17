package c0321g1_gaming.dto.order;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.services.Services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetailDto {
    private Long orderDetailId;
    private  Long orderId;
    private Long serviceId;
    private Order order;
    @NotNull
    @Min(1)
    private int quantity;
    private int totalPrices;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, Long orderId, Long serviceId, Order order, @NotNull @Min(1) int quantity, int totalPrices) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.serviceId = serviceId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

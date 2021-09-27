package c0321g1_gaming.dto.order;
import c0321g1_gaming.dto.services.ServicesDto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderDetailDto {
    private Long orderDetailId;
    private ServicesDto services;
    private OrderDto order;
    @NotNull
    @Min(1)
    private int quantity;
    private int totalPrices;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, ServicesDto services, OrderDto order, @NotNull @Min(1) int quantity, int totalPrices) {
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

    public ServicesDto getServices() {
        return services;
    }

    public void setServices(ServicesDto services) {
        this.services = services;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
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
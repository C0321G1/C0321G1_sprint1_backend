package c0321g1_gaming.dto.order;



public class OrderDetailDto {
    private Long orderDetailId;
    private  Long orderId;
    private Long ServiceId;
    private int quantity;
    private int totalPrices;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDetailId, Long orderId, Long serviceId, int quantity, int totalPrices) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        ServiceId = serviceId;
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
        return ServiceId;
    }

    public void setServiceId(Long serviceId) {
        ServiceId = serviceId;
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

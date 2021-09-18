package c0321g1_gaming.model.entity.order;

import c0321g1_gaming.model.entity.services.Services;
import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "servicesId", referencedColumnName = "servicesId")
    private Services services;
    private int quantity;
    private int totalPrices;

    public OrderDetail() {
    }

    public OrderDetail(Long orderDetailId, Order order, Services services, int quantity, int totalPrices) {
        this.orderDetailId = orderDetailId;
        this.order = order;
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

    public Order getOrders() {
        return order;
    }

    public void setOrders(Order order) {
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
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }
}

package c0321g1_gaming.model.entity.order;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.services.Services;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private int quantity;
    private int prices;
    private int totalPrices;
    @ManyToOne
    @JoinColumn(name = "servicesId", referencedColumnName = "servicesId")
    private Services services;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<OrderDetail> orderDetail;

    public Order() {
    }

    public Order(Long orderId, int quantity, int prices, int totalPrices, Services services, Customer customer, List<OrderDetail> orderDetail) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.prices = prices;
        this.totalPrices = totalPrices;
        this.services = services;
        this.customer = customer;
        this.orderDetail = orderDetail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(int totalPrices) {
        this.totalPrices = totalPrices;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}

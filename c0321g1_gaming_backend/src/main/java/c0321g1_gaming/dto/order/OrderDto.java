package c0321g1_gaming.dto.order;
import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.entity.services.Services;
import java.util.List;


public class OrderDto {
    private Long orderId;
    private int quantity;
    private int total;
    private Computer computer;
    private Services services;
    private Customer customer;
    private List<OrderDetail> orderDetail;
    public OrderDto() {
    }

    public OrderDto(Long orderId, int quantity, int total, Computer computer, Services services, Customer customer, List<OrderDetail> orderDetail) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.total = total;
        this.computer = computer;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
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

package c0321g1_gaming.model.entity.order;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(Long orderDetailId, Order order) {
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

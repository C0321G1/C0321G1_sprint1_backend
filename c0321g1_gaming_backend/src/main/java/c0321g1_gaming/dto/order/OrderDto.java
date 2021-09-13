package c0321g1_gaming.dto.order;

import c0321g1_gaming.dto.computer.ComputerDto;
import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.dto.services.ServicesDto;
import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.entity.services.Services;

import java.util.List;


public class OrderDto {
    private Long orderId;
    private  Customer customer;
    private int status =1;
    public OrderDto() {
    }

    public OrderDto(Long orderId, Customer customer, int status) {
        this.orderId = orderId;
        this.customer = customer;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

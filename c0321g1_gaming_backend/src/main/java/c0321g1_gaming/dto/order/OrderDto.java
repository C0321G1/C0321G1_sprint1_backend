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
    private Long  customerId;
    private int status =1;
    public OrderDto() {
    }

    public OrderDto(Long orderId, Long customerId, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

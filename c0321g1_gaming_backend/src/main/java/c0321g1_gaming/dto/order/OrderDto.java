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
    private int quantity;
    private int total;
    private Computer computerDto;
    private List<Services> servicesDtoList;
    private Customer customerDto;
    private OrderDetail orderDetailDto;
    public OrderDto() {
    }

    public OrderDto(Long orderId, int quantity, int total, Computer computerDto,
                    List<Services> servicesDtoList, Customer customerDto, OrderDetail orderDetailDto) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.total = total;
        this.computerDto = computerDto;
        this.servicesDtoList = servicesDtoList;
        this.customerDto = customerDto;
        this.orderDetailDto = orderDetailDto;
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

    public Computer getComputerDto() {
        return computerDto;
    }

    public void setComputerDto(Computer computerDto) {
        this.computerDto = computerDto;
    }

    public List<Services> getServicesDtoList() {
        return servicesDtoList;
    }

    public void setServicesDtoList(List<Services> servicesDtoList) {
        this.servicesDtoList = servicesDtoList;
    }

    public Customer getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(Customer customerDto) {
        this.customerDto = customerDto;
    }

    public OrderDetail getOrderDetailDto() {
        return orderDetailDto;
    }

    public void setOrderDetailDto(OrderDetail orderDetailDto) {
        this.orderDetailDto = orderDetailDto;
    }
}

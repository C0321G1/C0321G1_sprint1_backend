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
    private List<Services> servicesDtoList;
    private Customer customerDto;
    private OrderDetail orderDetailDto;
    private int prices;
    private int status=1;
    public OrderDto() {
    }

    public OrderDto(Long orderId, int quantity, int total, List<Services> servicesDtoList, Customer customerDto, OrderDetail orderDetailDto, int prices, int status) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.total = total;
        this.servicesDtoList = servicesDtoList;
        this.customerDto = customerDto;
        this.orderDetailDto = orderDetailDto;
        this.prices = prices;
        this.status = status;
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

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

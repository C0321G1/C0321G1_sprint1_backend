package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.customer.Customer;

import java.util.List;


public class CustomerStatusDto {
    private Long customerStatusId;
    private String name;
    private List<Customer> customerDtoList;

    public CustomerStatusDto() {
    }

    public CustomerStatusDto(Long customerStatusId, String name, List<Customer> customerDtoList) {
        this.customerStatusId = customerStatusId;
        this.name = name;
        this.customerDtoList = customerDtoList;
    }

    public Long getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(Long customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerDtoList() {
        return customerDtoList;
    }

    public void setCustomerDtoList(List<Customer> customerDtoList) {
        this.customerDtoList = customerDtoList;
    }
}

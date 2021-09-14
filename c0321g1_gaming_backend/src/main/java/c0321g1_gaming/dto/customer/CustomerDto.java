package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.security.Account;

import java.util.List;


public class CustomerDto {
    private Long customerId;
    private String email;
    private String dateOfBirth;
    private String fullName;
    private int flagDelete;
    private String phone;
    private List<Address> addressDtoList;
    private CustomerStatus customerStatusDto;
    private List<Order> orderDtoList;
    private Account accountDto;
    private String code;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String email, String dateOfBirth, String fullName, int flagDelete, String phone, List<Address> addressDtoList, CustomerStatus customerStatusDto, List<Order> orderDtoList, Account accountDto, String code) {
        this.customerId = customerId;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.flagDelete = flagDelete;
        this.phone = phone;
        this.addressDtoList = addressDtoList;
        this.customerStatusDto = customerStatusDto;
        this.orderDtoList = orderDtoList;
        this.accountDto = accountDto;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAddressDtoList() {
        return addressDtoList;
    }

    public void setAddressDtoList(List<Address> addressDtoList) {
        this.addressDtoList = addressDtoList;
    }

    public CustomerStatus getCustomerStatusDto() {
        return customerStatusDto;
    }

    public void setCustomerStatusDto(CustomerStatus customerStatusDto) {
        this.customerStatusDto = customerStatusDto;
    }

    public List<Order> getOrderDtoList() {
        return orderDtoList;
    }

    public void setOrderDtoList(List<Order> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }

    public Account getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(Account accountDto) {
        this.accountDto = accountDto;
    }
}

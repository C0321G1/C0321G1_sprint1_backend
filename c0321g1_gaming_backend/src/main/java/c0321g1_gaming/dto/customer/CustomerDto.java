package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.CustomerStatus;

import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.security.Account;

import java.util.List;

public class CustomerDto {
    private Long customerId;
    private String email;
    private String dateOfBirth;
    private String fullName;
    private int flag;
    private String phone;
    private List<Address> addressDtoList;
    private CustomerStatus customerStatusDto;
    private List<Order> orderDtoList;
    private Account accountDto;
    private Address address;
    private CustomerStatus customerStatus;
    private List<Order> orderList;
    private Account account;

    private String code;
    private Gender gender;

    public CustomerDto() {
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

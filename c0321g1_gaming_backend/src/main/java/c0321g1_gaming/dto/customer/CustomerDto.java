package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.security.Account;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


public class CustomerDto {
    private Long customerId;
    private String email;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String fullName;
    private int flag;
    @NotEmpty
    @Pattern(regexp = "\\d{10,12}", message = "Phone must have 10 -12 number")
    private String phone;
    private Address address;
    private CustomerStatus customerStatus;
    private List<Order> orderList;
    private Account account;
    private String code;
    private Gender gender;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String email, String dateOfBirth, @NotEmpty String fullName, int flag, @NotEmpty @Pattern(regexp = "\\d{10,12}", message = "Phone must have 10 -12 number") String phone, Address address, CustomerStatus customerStatus, List<Order> orderList, @NotNull Account account, String code, Gender gender) {
        this.customerId = customerId;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.flag = flag;
        this.phone = phone;
        this.address = address;
        this.customerStatus = customerStatus;
        this.orderList = orderList;
        this.account = account;
        this.code = code;
        this.gender = gender;
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

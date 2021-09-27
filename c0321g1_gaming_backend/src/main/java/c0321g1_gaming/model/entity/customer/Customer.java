package c0321g1_gaming.model.entity.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    private String email;
    private String code;
    private String dateOfBirth;
    private String fullName;
    private int flag;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "statusId", referencedColumnName = "customerStatusId")
    private CustomerStatus customerStatus;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference(value = "customer-orderList")
    private List<Order> orderList;

    @OneToOne
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;

    public Customer() {
    }

    public Customer(Long customerId, String email, String code, String dateOfBirth, String fullName, int flag, String phone, Address address, CustomerStatus customerStatus, List<Order> orderList, Account account, Gender gender) {
        this.customerId = customerId;
        this.email = email;
        this.code = code;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.flag = flag;
        this.phone = phone;
        this.address = address;
        this.customerStatus = customerStatus;
        this.orderList = orderList;
        this.account = account;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setFlag(int flagDelete) {
        this.flag = flagDelete;
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
}

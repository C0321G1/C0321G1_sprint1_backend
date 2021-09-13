package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.gender.Gender;


public class CusDTO {
    private Long customerId;
    private String code;
    private String email;
    private String dateOfBirth;
    private String fullName;
    private int flag;
    private String phone;
    private Address address;
    private CustomerStatus customerStatus;
    private Gender gender;
    private String password;
    private String username;

    public CusDTO() {
    }

    public CusDTO(Long customerId, String code, String email, String dateOfBirth, String fullName, int flag, String phone, Address address, CustomerStatus customerStatus, Gender gender, String password, String username) {
        this.customerId = customerId;
        this.code = code;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.flag = flag;
        this.phone = phone;
        this.address = address;
        this.customerStatus = customerStatus;
        this.gender = gender;
        this.password = password;
        this.username = username;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getFlag(int i) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

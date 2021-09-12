package c0321g1_gaming.dto.customer;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.entity.employee.Gender;

public class CusDTO {
    private Long customerId;
    private String fullName;
    private String username;
    private String email;
    private String dateOfBirth;
    private String phone;
    private String password;
    private Address address;
    private Gender gender;
    private CustomerStatus customerStatus;

    public CusDTO() {
    }

    public CusDTO(Long customerId, String fullName, String username, String email, String dateOfBirth, String phone, String password, Address address, Gender gender, CustomerStatus customerStatus) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.customerStatus = customerStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }
}

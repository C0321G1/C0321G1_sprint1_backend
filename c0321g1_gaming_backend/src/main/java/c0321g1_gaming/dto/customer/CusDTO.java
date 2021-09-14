package c0321g1_gaming.dto.customer;


import javax.validation.constraints.NotBlank;

public class CusDTO {
    private Long customerId;
    private String fullName;
    private String email;
    @NotBlank(message = "Please input date of birth")
    private String dateOfBirth;
    private String phone;
    private Long addressId;
    private Long genderId;
    private String password;
    private String username;
    private int flag;
    private Long customerStatusId;

    public CusDTO() {
    }

    public CusDTO(Long customerId, String fullName, String email, String dateOfBirth, String phone, Long addressId, Long genderId, String password, String username, int flag, Long customerStatusId) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.addressId = addressId;
        this.genderId = genderId;
        this.password = password;
        this.username = username;
        this.flag = flag;
        this.customerStatusId = customerStatusId;
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Long getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(Long customerStatusId) {
        this.customerStatusId = customerStatusId;
    }
}

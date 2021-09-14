package c0321g1_gaming.model.entity.employee;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String yearOfExp;
    private String code;
    private String phone;
    private String dateOfBirth;
    private String startWorkDate;
    private String level;
    private String email;
    private String fullName;

    private int flagDelete;
    @ManyToMany
    @JoinTable(name = "employee_address",
            joinColumns = @JoinColumn(name = "employeeId")
            , inverseJoinColumns = @JoinColumn(name = "addressId"))
    @JsonBackReference
    private List<Address> addressList;
    @ManyToOne(targetEntity = Gender.class)
    @JoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

    public Employee() {
    }

    public Employee(Long employeeId, String yearOfExp, String code, String phone, String dateOfBirth, String startWorkDate, String level, String email, String fullName, int flagDelete, List<Address> addressList, Position position, Account account) {
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.code = code;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
        this.fullName = fullName;
        this.flagDelete = flagDelete;
        this.addressList = addressList;
        this.position = position;
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(String yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(String startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

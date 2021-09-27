package c0321g1_gaming.model.entity.employee;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.security.Account;

import javax.persistence.*;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private Long yearOfExp;
    private String code;
    private String phone;
    private String dateOfBirth;
    private String startWorkDate;
    private Long level;
    private String email;
    private String fullName;
    private String image;
    private int flagDel;

    @ManyToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    private Account account;

    public Employee() {
    }

    public Employee(Long employeeId, Long yearOfExp, String code, String phone, String dateOfBirth, String startWorkDate, Long level, String email, String fullName,
                    String image, int flagDel, Address address, Position position, Gender gender, Account account) {
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.code = code;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
        this.fullName = fullName;
        this.image = image;
        this.flagDel = flagDel;
        this.address = address;
        this.position = position;
        this.gender = gender;
        this.account = account;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(Long yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(int flagDel) {
        this.flagDel = flagDel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
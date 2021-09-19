package c0321g1_gaming.model.entity.employee;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.security.Account;


import javax.persistence.*;

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
    private String image;
<<<<<<< HEAD
    private int flagDel;

=======
    private int flagDelete;
>>>>>>> origin
    @ManyToOne
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "genderId", referencedColumnName = "genderId")
    private Gender gender;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

    public Employee() {
    }

<<<<<<< HEAD
    public Employee(Long employeeId, Long yearOfExp, String code, String phone, String dateOfBirth, String startWorkDate, Long level, String email, String fullName,
                    String image, int flagDel, Address address, Position position, Gender gender, Account account) {
=======
    public Employee(Long employeeId, String yearOfExp, String code, String phone, String dateOfBirth, String startWorkDate, String level, String email, String name, int flagDelete, Address address, Position position, Account account) {
>>>>>>> origin
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.code = code;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
<<<<<<< HEAD
        this.fullName = fullName;
        this.image = image;
        this.flagDel = flagDel;
=======
        this.name = name;
        this.flagDelete = flagDelete;
>>>>>>> origin
        this.address = address;
        this.position = position;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

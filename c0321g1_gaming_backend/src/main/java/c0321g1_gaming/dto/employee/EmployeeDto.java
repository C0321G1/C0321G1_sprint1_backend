package c0321g1_gaming.dto.employee;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.employee.Gender;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.entity.security.Account;

import java.util.List;


public class EmployeeDto {
    private Long employeeId;
    private String yearOfExp;
    private String phone;
    private String dateOfBirth;
    private String startWorkDate;
    private String level;
    private String email;
    private String fullName;
    private String code;
    private String image;
    private int flagDel;
    private List<Address> addressList;
    private Position position;
    private Account account;
    private Gender gender;
    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, String yearOfExp, String phone, String dateOfBirth, String startWorkDate, String level, String email, String fullName, String code, int flagDel, List<Address> addressList, Position position, Account account) {
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
        this.fullName = fullName;
        this.code = code;
        this.flagDel = flagDel;
        this.addressList = addressList;
        this.position = position;
        this.account = account;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCode() {
        return code;
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

    public int getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(int flagDel) {
        this.flagDel = flagDel;
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

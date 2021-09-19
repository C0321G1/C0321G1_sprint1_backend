package c0321g1_gaming.dto.employee;

import c0321g1_gaming.dto.address.AddressDto;
import c0321g1_gaming.dto.security.AccountDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.entity.security.Account;

<<<<<<< HEAD
import javax.validation.constraints.*;
=======
import java.util.List;

>>>>>>> origin

public class EmployeeDto {

    private Long employeeId;
<<<<<<< HEAD

    @NotNull
    @Min(0)
    private Long yearOfExp;

    @NotEmpty
    @Pattern(regexp = "(0\\d{9,10})")
=======
    private String yearOfExp;
>>>>>>> origin
    private String phone;

    @NotEmpty
    private String dateOfBirth;

    @NotEmpty
    private String startWorkDate;
<<<<<<< HEAD

    @NotNull
    @Min(1)
    private Long level;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")
=======
    private String level;
>>>>>>> origin
    private String email;

    @NotEmpty
    @Size(min = 6, max = 50)
    private String fullName;

    @NotEmpty
    @Pattern(regexp = "EMP-\\d{4}")
    private String code;
<<<<<<< HEAD

    private String image;
    private int flagDel;
    private Address address;
    private Position position;
    private Account account;
    private Gender gender;
=======
>>>>>>> origin


    private int flagDelete;
    private List<Address> addressDtoList;
    private Position positionDto;
    private Account accountDto;
    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, String yearOfExp, String phone, String dateOfBirth, String startWorkDate, String level, String email, String fullName, String code, int flagDelete, List<Address> addressDtoList, Position positionDto, Account accountDto) {
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
        this.fullName = fullName;
        this.code = code;
        this.flagDelete = flagDelete;
        this.addressDtoList = addressDtoList;
        this.positionDto = positionDto;
        this.accountDto = accountDto;
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

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public List<Address> getAddressDtoList() {
        return addressDtoList;
    }

    public void setAddressDtoList(List<Address> addressDtoList) {
        this.addressDtoList = addressDtoList;
    }

    public Position getPositionDto() {
        return positionDto;
    }

    public void setPositionDto(Position positionDto) {
        this.positionDto = positionDto;
    }

    public Account getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(Account accountDto) {
        this.accountDto = accountDto;
    }
}

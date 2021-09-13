package c0321g1_gaming.dto.employee;

import c0321g1_gaming.dto.address.AddressDto;
import c0321g1_gaming.dto.security.AccountDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.entity.security.Account;

import java.util.List;


public class EmployeeDto {
    private Long employeeId;
    private Long yearOfExp;
    private String phone;
    private String dateOfBirth;
    private String startWorkDate;
    private Long level;
    private String email;
    private String fullName;
    private String code;


    private int flagDelete;
    private List<Address> addressDtoList;
    private Position positionDto;
    private Account accountDto;

    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, Long yearOfExp, String phone, String dateOfBirth, String startWorkDate, Long level, String email, String fullName, String code, int flagDelete, List<Address> addressDtoList, Position positionDto, Account accountDto) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

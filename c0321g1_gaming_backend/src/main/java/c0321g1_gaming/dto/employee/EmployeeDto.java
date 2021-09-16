package c0321g1_gaming.dto.employee;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.entity.security.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class EmployeeDto implements Validator {

    private Long employeeId;

    @NotNull
    @Min(0)
    private Long yearOfExp;

    @NotEmpty
    @Pattern(regexp = "(0\\d{9,10})")
    private String phone;

    @NotEmpty
    private String dateOfBirth;

    @NotEmpty
    private String startWorkDate;

    @NotNull
    @Min(1)
    private Long level;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")
    private String email;

    @NotEmpty
    @Size(min = 6, max = 50)
    private String fullName;

    @NotEmpty
    @Pattern(regexp = "EMP-\\d{4}")
    private String code;

    private String image;
    private int flagDel;
    private Address address;
    private Position position;
    private Account account;
    private Gender gender;

    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, Long yearOfExp, String phone, String dateOfBirth, String startWorkDate, Long level, String email, String fullName, String code, String image, int flagDel, Address address, Position position, Account account, Gender gender) {
        this.employeeId = employeeId;
        this.yearOfExp = yearOfExp;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.startWorkDate = startWorkDate;
        this.level = level;
        this.email = email;
        this.fullName = fullName;
        this.code = code;
        this.image = image;
        this.flagDel = flagDel;
        this.address = address;
        this.position = position;
        this.account = account;
        this.gender = gender;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar period = Calendar.getInstance();
        Date date = null;
        try {
            date = dateFormat.parse(employeeDto.getDateOfBirth());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            period.setTime(date);
        }
        period.add(Calendar.DATE, 18 * 365);
        if (period.getTimeInMillis() - System.currentTimeMillis() > 0) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Age must be not less than 18");
        }

        int timeDiff = employeeDto.getStartWorkDate().compareTo(LocalDate.now().toString());
        if (timeDiff < 0) {
            errors.rejectValue("startWorkDate", "startWorkDate", "Start work date must be not in past");
        }
    }
}

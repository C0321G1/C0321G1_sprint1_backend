package c0321g1_gaming.model.service.employee.impl;

import c0321g1_gaming.dto.employee.EmployeeDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.repository.employee.EmployeeRepository;
import c0321g1_gaming.model.repository.security.AccountRepository;
import c0321g1_gaming.model.service.employee.EmployeeService;
import c0321g1_gaming.model.service.security.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Page<Employee> getListEmployee(Pageable pageable) {
        return employeeRepository.getListEmployee(pageable);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String employeeId, String dateBirthFrom, String dateBirthTo, String dateWorkFrom, String dateWorkTo, String position, String province) {
        return employeeRepository.searchEmployee(pageable, employeeId, dateBirthFrom, dateBirthTo, dateWorkFrom, dateWorkTo, position, province);
    }

    //Linh create method saveEmployee
    @Override
    public Map<String, Object> saveEmployee(EmployeeDto employeeDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();

        List<String> errors = new ArrayList<>();
        boolean isError = false;
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(ob -> {
                errors.add(ob.getDefaultMessage());
            });
            result.put("status", false);
            result.put("msg", "Add new employee failed.");
            result.put("errors", errors);
            isError = true;
        }
        if (checkEmail(employeeDto)) {
            result.put("status", false);
            result.put("msgEmail", "Email already used, please input again.");
            isError = true;
        }
        if (!checkPassword(employeeDto)) {
            result.put("status", false);
            result.put("msgPassword", "Password not right format, please input again.");
            isError = true;
        }
        if (checkCode(employeeDto)) {
            result.put("status", false);
            result.put("msgCode", "Employee ID already used, please input again.");
            isError = true;
        }
        if (!checkDateOfBirth(employeeDto)) {
            result.put("status", false);
            result.put("msgDateOfBirth", "Age not enough 18, please input again.");
            isError = true;
        }
        if (!checkDateExist(employeeDto)) {
            result.put("status", false);
            result.put("msgDateOfBirth", "The date is not valid, please input again.");
            isError = true;
        }
        if (checkStartWorkDate(employeeDto)) {
            result.put("status", false);
            result.put("msgStartWorkDate", "Start work date must be not in past, please input again.");
            isError = true;
        }
        if (isError) {
            return result;
        }
        Employee employee = new Employee();
        Address address = employeeDto.getAddress();
        Account account = employeeDto.getAccount();
        employeeDto.setFullName(employeeDto.getFullName().trim());
        employeeDto.setPhone(employeeDto.getPhone().trim());
        employeeDto.setEmail(employeeDto.getEmail().trim());
        if (employeeDto.getImage() == null) {
            if (employeeDto.getGender().getGenderId() == 1) {
                employeeDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/21-09-2021103726AMemployee_5_m.jpg?alt=media&token=4b90862a-7c15-4fe9-964a-380c66cbb199");
            } else {
                employeeDto.setImage("https://firebasestorage.googleapis.com/v0/b/c0321g1-sprint1.appspot.com/o/21-09-2021100437AMemployee_2_f.jpg?alt=media&token=09a82063-9aa6-4fe5-9be1-f329395e51ca");
            }
        }
        BeanUtils.copyProperties(employeeDto, employee);
        Long addressId = this.initAddressId(address);
        if (addressId != null) {
            address.setAddressId(addressId);
        } else {
            addressRepository.saveAddress(address.getProvince().getProvinceId(),
                    address.getDistrict().getDistrictId(),
                    address.getCommune().getCommuneId());
            address.setAddressId(this.initAddressId(address));
        }
        String passEncode = passwordEncoder.encode(account.getPassword());
        accountRepository.saveQuery(account.getUsername(), passEncode, null);
        account.setAccountId(this.initAccountId(account));
        accountRepository.saveRole(account.getAccountId(),3L);
        employeeRepository.saveEmployee(employee.getYearOfExp(), employee.getCode(), employee.getPhone(), employee.getDateOfBirth(),
                employee.getStartWorkDate(), employee.getLevel(), employee.getEmail(), employee.getFullName(),
                employee.getImage(), employee.getAddress().getAddressId(), employee.getPosition().getPositionId(),
                employee.getGender().getGenderId(), employee.getAccount().getAccountId(), 0);
        result.put("status", true);
        result.put("msg", "Add new employee successfully.");
        return result;
    }

    //Linh create method findById
    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    //Linh create method editEmployee
    @Override
    public Map<String, Object> editEmployee(EmployeeDto employeeDto, BindingResult bindingResult) {
        Map<String, Object> result = new HashMap<>();
        List<String> errors = new ArrayList<>();
        boolean isError = false;
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(ob -> {
                errors.add(ob.getDefaultMessage());
            });
            result.put("status", false);
            result.put("msg", "Edit employee failed.");
            result.put("errors", errors);
            isError = true;
        }
        if (checkEmailByEdit(employeeDto)) {
            result.put("status", false);
            result.put("msgEmail", "Email already used, please input again.");
            isError = true;
        }

        String newPassword = employeeDto.getAccount().getPassword();
        if (newPassword.equals("")) {
            Account account = employeeDto.getAccount();
            List<Account> accountList = accountRepository.getAccountList();
            for (Account a: accountList) {
                if (a.getAccountId().equals(employeeDto.getAccount().getAccountId())) {
                    newPassword = a.getPassword();
                    break;
                }
            }
            account.setPassword(newPassword);
        } else {
            if (!checkPassword(employeeDto)) {
                result.put("status", false);
                result.put("msgPassword", "Password not right format, please input again.");
                isError = true;
            }
        }

        if (!checkDateOfBirth(employeeDto)) {
            result.put("status", false);
            result.put("msgDateOfBirth", "Age not enough 18, please input again.");
            isError = true;
        }
        if (checkStartWorkDate(employeeDto)) {
            result.put("status", false);
            result.put("msgStartWorkDate", "Start work date must be not in past, please input again.");
            isError = true;
        }
        if (isError) {
            return result;
        }
        Employee employee = new Employee();
        Address address = employeeDto.getAddress();
        employeeDto.setFullName(employeeDto.getFullName().trim());
        employeeDto.setPhone(employeeDto.getPhone().trim());
        employeeDto.setEmail(employeeDto.getEmail().trim());
        BeanUtils.copyProperties(employeeDto, employee);
        Long addressId = this.initAddressId(address);
        if (addressId != null) {
            address.setAddressId(addressId);
        } else {
            addressRepository.saveAddress(address.getProvince().getProvinceId(),
                    address.getDistrict().getDistrictId(),
                    address.getCommune().getCommuneId());
            address.setAddressId(this.initAddressId(address));
        }

        employeeRepository.editEmployee(employee.getYearOfExp(), employee.getCode(), employee.getPhone(),
                employee.getDateOfBirth(), employee.getStartWorkDate(), employee.getLevel(),
                employee.getEmail(), employee.getFullName(), employee.getImage(), employee.getAddress().getAddressId(),
                employee.getPosition().getPositionId(), employee.getGender().getGenderId(),
                employee.getAccount().getAccountId(), employee.getEmployeeId());

        String passEncode = passwordEncoder.encode(employee.getAccount().getPassword());
        accountRepository.editAccountQuery(employee.getAccount().getUsername(), passEncode, employee.getAccount().getAccountId());
        result.put("status", true);
        result.put("msg", "Edit successfully !");
        return result;
    }

    private Long initAccountId(Account account) {
        List<Account> accountList = accountRepository.getAccountList();
        for (Account value : accountList) {
            if (value.getUsername().equals(account.getUsername())) {
                return value.getAccountId();
            }
        }
        return null;
    }

    private boolean checkStartWorkDate(EmployeeDto employeeDto) {
        int timeDiff = employeeDto.getStartWorkDate().compareTo(LocalDate.now().toString());
        return timeDiff < 0;
    }

    private boolean checkDateOfBirth(EmployeeDto employeeDto) {
        String date = employeeDto.getDateOfBirth();
        Calendar today = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        try {
            dateOfBirth.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (Exception e) {
            return false;
        }
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH);
        int day = today.get(Calendar.DATE) - dateOfBirth.get(Calendar.DATE);
        if (month < 0 || (day < 0 && month == 0)) {
            age--;
        }
        return age >= 18;
    }

    private boolean checkDateExist(EmployeeDto employeeDto) {
        String date = employeeDto.getDateOfBirth();
        Calendar today = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        try {
            dateOfBirth.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (Exception e) {
            return false;
        }
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if (age > 100) {
            return false;
        }
        int month = today.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH);
        int day = today.get(Calendar.DATE) - dateOfBirth.get(Calendar.DATE);
        return month != 2 || (day <= 29);
    }

    private boolean checkCode(EmployeeDto employeeDto) {
        List<Employee> employeeList = employeeRepository.getEmployeeList();
        for (Employee e : employeeList) {
            if (employeeDto.getCode().equals(e.getCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkEmail(EmployeeDto employeeDto) {
        List<Account> accountList = accountRepository.getAccountList();
        for (Account a : accountList) {
            if (employeeDto.getAccount().getUsername().equals(a.getUsername())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword(EmployeeDto employeeDto) {
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+~])[A-Za-z\\d!@#$%^&*()_+~]{6,}";
        return employeeDto.getAccount().getPassword().matches(regex);
    }

    private boolean checkEmailByEdit(EmployeeDto employeeDto) {
        List<Account> accountList = accountRepository.getAccountList();
        int count = 0;
        for (Account a : accountList) {
            if (employeeDto.getAccount().getUsername().equals(a.getUsername()) &&
                    !employeeDto.getAccount().getAccountId().equals(a.getAccountId())) {
                count++;
            }
        }
        return count > 0;
    }

    private Long initAddressId(Address address) {
        List<Address> addressList = addressRepository.getAddressList();
        for (Address value : addressList) {
            boolean checkProvince = value.getProvince().getName().equals(address.getProvince().getName());
            boolean checkDistrict = value.getDistrict().getName().equals(address.getDistrict().getName());
            boolean checkCommune = value.getCommune().getName().equals(address.getCommune().getName());
            if (checkProvince && checkDistrict && checkCommune) {
                return value.getAddressId();
            }
        }
        return null;
    }
}

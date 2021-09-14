package c0321g1_gaming.model.service.employee.impl;

import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.repository.employee.EmployeeRepository;
import c0321g1_gaming.model.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getYearOfExp(), employee.getCode(), employee.getPhone(), employee.getDateOfBirth(),
                employee.getStartWorkDate(), employee.getLevel(), employee.getEmail(), employee.getFullName(),
                employee.getImage(), employee.getAddress().getAddressId(), employee.getPosition().getPositionId(),
                employee.getGender().getGenderId(), 0);
    }

    //Linh create method findById
    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    //Linh create method editEmployee
    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(employee.getYearOfExp(), employee.getCode(), employee.getPhone(), employee.getDateOfBirth(),
                employee.getStartWorkDate(), employee.getLevel(), employee.getEmail(), employee.getFullName(),
                employee.getImage(), employee.getAddress().getAddressId(), employee.getPosition().getPositionId(),
                employee.getGender().getGenderId(), employee.getAccount().getAccountId(), employee.getEmployeeId());

    }
}

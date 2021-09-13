package c0321g1_gaming.model.service.employee;

import c0321g1_gaming.model.entity.employee.Employee;

import java.util.Optional;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    Optional<Employee> findById(Long id);
}

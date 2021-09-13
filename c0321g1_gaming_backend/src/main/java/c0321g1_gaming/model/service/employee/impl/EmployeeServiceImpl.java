package c0321g1_gaming.model.service.employee.impl;

import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.repository.employee.EmployeeRepository;
import c0321g1_gaming.model.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}

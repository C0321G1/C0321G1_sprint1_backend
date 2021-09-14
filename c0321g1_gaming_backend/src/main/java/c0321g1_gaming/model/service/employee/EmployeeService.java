package c0321g1_gaming.model.service.employee;

import c0321g1_gaming.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {

    Page<Employee> getListEmployee(Pageable pageable);

    void deleteEmployee(int id);

    Page<Employee> searchEmployee(Pageable pageable,String employeeId, String dateBirthFrom,
                                  String dateBirthTo, String dateWorkFrom, String dateWorkTo,
                                  String position, String province);

    //Linh create method saveEmployee
    void saveEmployee(Employee employee);

    //Linh create method findById
    Optional<Employee> findById(Long id);

    //Linh create method editEmployee
    void editEmployee(Employee employee);

}



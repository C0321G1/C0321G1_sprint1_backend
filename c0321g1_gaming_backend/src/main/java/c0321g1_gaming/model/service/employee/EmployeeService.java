package c0321g1_gaming.model.service.employee;

import c0321g1_gaming.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> getListEmployee(Pageable pageable);
    void deleteEmployee(int id);
    Page<Employee> searchEmployee(Pageable pageable,String employeeId, String dateBirthFrom,
                                  String dateBirthTo, String dateWorkFrom, String dateWorkTo,
                                  String position, String province);
}

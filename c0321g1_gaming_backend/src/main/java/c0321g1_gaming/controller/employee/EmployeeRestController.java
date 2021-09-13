package c0321g1_gaming.controller.employee;

import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;
    // khue create get list employee
    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees = employeeService.getListEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    // khue create method delete Employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // khue create method search Employee
    @GetMapping("employee/search")
    public ResponseEntity<Page<Employee>> getSearchEmployee(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String employeeId,
                                                            @RequestParam(defaultValue = "") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "") String dateBirthTo,
                                                            @RequestParam(defaultValue = "") String dateWorkFrom,
                                                            @RequestParam(defaultValue = "") String dateWorkTo,
                                                            @RequestParam(defaultValue = "")String position,
                                                            @RequestParam(defaultValue = "")String province ) {
        Page<Employee> employees = employeeService.searchEmployee(pageable,employeeId,dateBirthFrom,dateBirthTo,
                dateWorkFrom,dateWorkTo,position,province);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}

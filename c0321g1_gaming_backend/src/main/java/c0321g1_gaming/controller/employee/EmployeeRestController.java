package c0321g1_gaming.controller.employee;

import c0321g1_gaming.dto.employee.EmployeeDto;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.employee.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AddressService addressService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        addressService.saveAddress(employeeDto.getAddress());
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employeeOptional = employeeService.findById(employeeId);
        if(!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> editEmployee(@RequestBody EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());
        if(!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Employee employee = employeeOptional.get();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}

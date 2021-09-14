package c0321g1_gaming.controller.employee;

import c0321g1_gaming.dto.employee.EmployeeDto;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.employee.Employee;
import c0321g1_gaming.model.service.address.AddressService;
import c0321g1_gaming.model.service.employee.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    AddressService addressService;

    // khue create get list employee
    @GetMapping("/employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees = employeeService.getListEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    // khue create method delete Employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        if (id == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            Optional<Employee> employeeOptional = employeeService.findById((long) id);
            if(!employeeOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                this.employeeService.deleteEmployee(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
    }

    // khue create method search Employee
    @GetMapping("employee/search")
    public ResponseEntity<Page<Employee>> getSearchEmployee(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestParam(defaultValue = "") String employeeId,
                                                            @RequestParam(defaultValue = "1900-01-01") String dateBirthFrom,
                                                            @RequestParam(defaultValue = "2050-12-12") String dateBirthTo,
                                                            @RequestParam(defaultValue = "1900-01-01") String dateWorkFrom,
                                                            @RequestParam(defaultValue = "2050-12-12") String dateWorkTo,
                                                            @RequestParam(defaultValue = "")String position,
                                                            @RequestParam(defaultValue = "")String province ) {
        Page<Employee> employees = employeeService.searchEmployee(pageable,employeeId,dateBirthFrom,dateBirthTo,
                dateWorkFrom,dateWorkTo,position,province);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Linh create method createEmployee
    @PostMapping("/employee")
    public ResponseEntity<List<FieldError>> createEmployee(@RequestBody @Valid EmployeeDto employeeDto,
                                                           BindingResult bindingResult) {

        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Employee employee = new Employee();
        Address address = employeeDto.getAddress();
        BeanUtils.copyProperties(employeeDto, employee);

        boolean isAddressExist = false;
        List<Address> addressList = addressService.getAddressList();
        for (Address value : addressList) {
            if (value.equals(address)) {
                address.setAddressId(value.getAddressId());
                isAddressExist = true;
                break;
            }
        }
        if (!isAddressExist) {
            addressService.saveAddress(employeeDto.getAddress());
            System.err.println("aaa");
        }
        address.setAddressId(addressService.getAddressList().get(addressList.size()).getAddressId());
        System.err.println(address.getAddressId());
        System.err.println(employee.getAddress().getAddressId());
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Linh create method getEmployee
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if(!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }

    // Linh create method editEmployee
    @PatchMapping("/employee")
    public ResponseEntity<List<FieldError>> editEmployee(@RequestBody @Valid EmployeeDto employeeDto,
                                                         BindingResult bindingResult) {
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());

        if(!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Employee employee = employeeOptional.get();
        Address address = employeeDto.getAddress();
        BeanUtils.copyProperties(employeeDto, employee);
        addressService.saveAddress(employeeDto.getAddress());
        List<Address> addressList = addressService.getAddressList();
        address.setAddressId(addressList.get(addressList.size()).getAddressId());
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

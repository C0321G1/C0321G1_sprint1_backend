package c0321g1_gaming.dto.employee;

import c0321g1_gaming.model.entity.employee.Employee;
import java.util.List;

public class GenderDto {
    private Long genderId;
    private String name;
    private List<Employee> employeeList;

    public GenderDto() {
    }

    public GenderDto(Long genderId, String name, List<Employee> employeeList) {
        this.genderId = genderId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

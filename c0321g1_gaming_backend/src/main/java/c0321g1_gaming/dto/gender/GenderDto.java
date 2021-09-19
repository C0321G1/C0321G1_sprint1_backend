package c0321g1_gaming.dto.gender;

import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;

public class GenderDto {
    private Long genderId;
    private String name;
    private List<Employee> employeeList;
    private List<Customer> customerList;

    public GenderDto() {
    }

    public GenderDto(Long genderId, String name, List<Employee> employeeList, List<Customer> customerList) {
        this.genderId = genderId;
        this.name = name;
        this.employeeList = employeeList;
        this.customerList = customerList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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

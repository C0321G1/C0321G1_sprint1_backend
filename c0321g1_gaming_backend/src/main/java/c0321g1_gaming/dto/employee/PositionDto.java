package c0321g1_gaming.dto.employee;

import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;


public class PositionDto {
    private Long positionId;
    private String name;
    private List<Employee> employeeList;

    public PositionDto() {
    }

    public PositionDto(Long positionId, String name, List<Employee> employeeList) {
        this.positionId = positionId;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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

package c0321g1_gaming.dto.employee;

import c0321g1_gaming.model.entity.employee.Employee;

import java.util.List;


public class PositionDto {
    private Long positionId;
    private String name;

    private List<Employee> employeeDtoList;


    public PositionDto() {
    }

    public PositionDto(Long positionId, String name, List<Employee> employeeDtoList) {
        this.positionId = positionId;
        this.name = name;
        this.employeeDtoList = employeeDtoList;
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

    public List<Employee> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<Employee> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
}

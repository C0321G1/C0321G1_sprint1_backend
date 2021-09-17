package c0321g1_gaming.model.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;
    private String name;
    @OneToMany(mappedBy = "gender",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public Gender() {
    }

    public Gender(Long genderId, String name, List<Employee> employeeList) {
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

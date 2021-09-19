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
    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    @JsonBackReference(value = "gender-employee")
    private List<Employee> employeeList;
<<<<<<< HEAD:c0321g1_gaming_backend/src/main/java/c0321g1_gaming/model/entity/gender/Gender.java
    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    @JsonBackReference(value = "gender-customer")
    private List<Customer> customerList;
=======

>>>>>>> origin:c0321g1_gaming_backend/src/main/java/c0321g1_gaming/model/entity/employee/Gender.java
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

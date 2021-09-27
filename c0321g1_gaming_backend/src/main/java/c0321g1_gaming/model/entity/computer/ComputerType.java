package c0321g1_gaming.model.entity.computer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
public class ComputerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerTypeId;
    private String name;
    @OneToMany(mappedBy = "computerType",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Computer> computerList;

    public ComputerType() {
    }

    public ComputerType(Long customerTypeId, String name, List<Computer> computerList) {
        this.computerTypeId = customerTypeId;
        this.name = name;
        this.computerList = computerList;
    }

    public Long getComputerTypeId() {
        return computerTypeId;
    }

    public void setComputerTypeId(Long computerTypeId) {
        this.computerTypeId = computerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }
}

package c0321g1_gaming.model.entity.computer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class ComputerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerStatusId;
    private String name;
    @OneToMany(mappedBy = "computerStatus",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Computer> computerList;

    public ComputerStatus() {
    }

    public ComputerStatus(Long computerStatusId, String name, List<Computer> computerList) {
        this.computerStatusId = computerStatusId;
        this.name = name;
        this.computerList = computerList;
    }

    public Long getComputerStatusId() {
        return computerStatusId;
    }

    public void setComputerStatusId(Long computerStatusId) {
        this.computerStatusId = computerStatusId;
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
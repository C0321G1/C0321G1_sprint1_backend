package c0321g1_gaming.model.entity.computer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
public class ComputerManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerManufacturerId;
    private String name;
    @OneToMany(mappedBy = "computerManufacturer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Computer> computerList;

    public ComputerManufacturer() {
    }

    public ComputerManufacturer(Long computerManufacturerId, String name, List<Computer> computerList) {
        this.computerManufacturerId = computerManufacturerId;
        this.name = name;
        this.computerList = computerList;
    }

    public Long getComputerManufacturerId() {
        return computerManufacturerId;
    }

    public void setComputerManufacturerId(Long computerManufacturerId) {
        this.computerManufacturerId = computerManufacturerId;
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

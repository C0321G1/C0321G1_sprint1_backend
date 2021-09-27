package c0321g1_gaming.model.entity.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unitId;
    private String name;
    @OneToMany(mappedBy = "unit",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Services> servicesList;

    public Unit() {
    }

    public Unit(String name, List<Services> servicesList) {
        this.name = name;
        this.servicesList = servicesList;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Services> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<Services> servicesList) {
        this.servicesList = servicesList;
    }
}
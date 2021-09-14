package c0321g1_gaming.dto.services;

import c0321g1_gaming.model.entity.services.Services;

import java.util.List;


public class UnitDto {
    private int unitId;
    private String name;
    private List<Services> servicesList;

    public UnitDto() {
    }

    public UnitDto(int unitId, String name, List<Services> servicesList) {
        this.unitId = unitId;
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

package c0321g1_gaming.dto.services;

import c0321g1_gaming.model.entity.services.Services;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


public class UnitDto {
    private int unitId;
    private String name;
    private List<Services> servicesDtoList;

    public UnitDto() {
    }

    public UnitDto(int unitId, String name, List<Services> servicesDtoList) {
        this.unitId = unitId;
        this.name = name;
        this.servicesDtoList = servicesDtoList;
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

    public List<Services> getServicesDtoList() {
        return servicesDtoList;
    }

    public void setServicesDtoList(List<Services> servicesDtoList) {
        this.servicesDtoList = servicesDtoList;
    }
}

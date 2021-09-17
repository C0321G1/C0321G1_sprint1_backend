package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.Computer;

import java.util.List;


public class ComputerTypeDto {
    private Long computerTypeId;
    private String name;

    private List<Computer> computerDtoList;


    public ComputerTypeDto() {
    }

    public ComputerTypeDto(Long computerTypeId, String name, List<Computer> computerDtoList) {
        this.computerTypeId = computerTypeId;
        this.name = name;
        this.computerDtoList = computerDtoList;
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

    public List<Computer> getComputerDtoList() {
        return computerDtoList;
    }

    public void setComputerDtoList(List<Computer> computerDtoList) {
        this.computerDtoList = computerDtoList;
    }
}

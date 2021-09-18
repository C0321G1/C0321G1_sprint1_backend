package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.Computer;

import java.util.List;


public class ComputerTypeDto {
    private Long computerTypeId;
    private String name;

    private List<Computer> computerList;


    private List<Computer> computerDtoList;



    public ComputerTypeDto() {
    }

    public ComputerTypeDto(Long computerTypeId, String name, List<Computer> computerList) {
        this.computerTypeId = computerTypeId;
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

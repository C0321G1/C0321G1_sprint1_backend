package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.Computer;

import java.util.List;


public class ComputerStatusDto {
    private Long computerStatusId;
    private String name;

    private List<Computer> computerDtoList;


    public ComputerStatusDto() {
    }

    public ComputerStatusDto(Long computerStatusId, String name, List<Computer> computerDtoList) {
        this.computerStatusId = computerStatusId;
        this.name = name;
        this.computerDtoList = computerDtoList;
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

    public List<Computer> getComputerDtoList() {
        return computerDtoList;
    }

    public void setComputerDtoList(List<Computer> computerDtoList) {
        this.computerDtoList = computerDtoList;
    }
}

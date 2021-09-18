package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.Computer;

import java.util.List;


public class ComputerStatusDto {
    private Long computerStatusId;
    private String name;

    private List<Computer> computerList;



    public ComputerStatusDto() {
    }

    public ComputerStatusDto(Long computerStatusId, String name, List<Computer> computerList) {
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

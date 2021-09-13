package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.Computer;

import java.util.List;
public class ComputerManufacturerDto {
    private Long computerManufacturerId;
    private String name;
    private List<Computer> computerList;

    public ComputerManufacturerDto() {
    }

    public ComputerManufacturerDto(Long computerManufacturerId, String name, List<Computer> computerList) {
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

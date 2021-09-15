package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.entity.computer.ComputerType;
import c0321g1_gaming.model.entity.order.Order;

import java.util.List;

public class ComputerDto {

    private Long computerId;
    private String computerCode;
    private String location;
    private String configuration;
    private String startUsedDate;
    private String warrantyPeriod;
    private int flagDelete;
    private ComputerStatus computerStatusDto;
    private ComputerType computerTypeDto;
    private ComputerManufacturer computerManufacturerDto;
    private List<Order> orderDtoList;
    public ComputerDto() {
    }

    public ComputerDto(Long computerId, String computerCode, String location, String configuration, String startUsedDate,
                       String warrantyPeriod, int flagDelete, ComputerStatus computerStatusDto, ComputerType computerTypeDto, ComputerManufacturer computerManufacturerDto, List<Order> orderDtoList) {
        this.computerId = computerId;
        this.computerCode = computerCode;
        this.location = location;
        this.configuration = configuration;
        this.startUsedDate = startUsedDate;
        this.warrantyPeriod = warrantyPeriod;
        this.flagDelete = flagDelete;
        this.computerStatusDto = computerStatusDto;
        this.computerTypeDto = computerTypeDto;
        this.computerManufacturerDto = computerManufacturerDto;
        this.orderDtoList = orderDtoList;
    }

    public Long getComputerId() {
        return computerId;
    }

    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    public String getComputerCode() {
        return computerCode;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getStartUsedDate() {
        return startUsedDate;
    }

    public void setStartUsedDate(String startUsedDate) {
        this.startUsedDate = startUsedDate;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public ComputerStatus getComputerStatusDto() {
        return computerStatusDto;
    }

    public void setComputerStatusDto(ComputerStatus computerStatusDto) {
        this.computerStatusDto = computerStatusDto;
    }

    public ComputerType getComputerTypeDto() {
        return computerTypeDto;
    }

    public void setComputerTypeDto(ComputerType computerTypeDto) {
        this.computerTypeDto = computerTypeDto;
    }

    public ComputerManufacturer getComputerManufacturerDto() {
        return computerManufacturerDto;
    }

    public void setComputerManufacturerDto(ComputerManufacturer computerManufacturerDto) {
        this.computerManufacturerDto = computerManufacturerDto;
    }

    public List<Order> getOrderDtoList() {
        return orderDtoList;
    }

    public void setOrderDtoList(List<Order> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }
}

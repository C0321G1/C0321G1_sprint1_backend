package c0321g1_gaming.dto.computer;

import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.entity.computer.ComputerType;
import c0321g1_gaming.model.entity.order.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

public class ComputerDto implements Validator {

    private Long computerId;
    private String computerCode;
    private String location;
    private String configuration;
    private String startUsedDate;
    private String warrantyPeriod;
    private int flagDelete;
    private ComputerStatus computerStatus;
    private ComputerType computerType;
    private ComputerManufacturer computerManufacturer;
    private List<Order> orderList;
    public ComputerDto() {
    }

    public ComputerDto(Long computerId, String computerCode, String location, String configuration, String startUsedDate,
                       String warrantyPeriod, int flagDelete, ComputerStatus computerStatus, ComputerType computerType, ComputerManufacturer computerManufacturer, List<Order> orderList) {
        this.computerId = computerId;
        this.computerCode = computerCode;
        this.location = location;
        this.configuration = configuration;
        this.startUsedDate = startUsedDate;
        this.warrantyPeriod = warrantyPeriod;
        this.flagDelete = flagDelete;
        this.computerStatus = computerStatus;
        this.computerType = computerType;
        this.computerManufacturer = computerManufacturer;
        this.orderList = orderList;
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

    public ComputerStatus getComputerStatus() {
        return computerStatus;
    }

    public void setComputerStatus(ComputerStatus computerStatus) {
        this.computerStatus = computerStatus;
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public void setComputerType(ComputerType computerType) {
        this.computerType = computerType;
    }

    public ComputerManufacturer getComputerManufacturer() {
        return computerManufacturer;
    }

    public void setComputerManufacturer(ComputerManufacturer computerManufacturer) {
        this.computerManufacturer = computerManufacturer;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

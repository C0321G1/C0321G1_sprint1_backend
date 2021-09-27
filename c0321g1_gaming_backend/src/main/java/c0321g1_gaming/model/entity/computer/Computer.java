package c0321g1_gaming.model.entity.computer;

import c0321g1_gaming.model.entity.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity

public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;
    private String computerCode;
    private String location;
    private String configuration;
    private String startUsedDate;
    private String warrantyPeriod;
    private int flagDelete;
    @ManyToOne
    @JoinColumn(name = "computerStatusId",referencedColumnName = "computerStatusId")
    private ComputerStatus computerStatus;
    @ManyToOne
    @JoinColumn(name = "computerTypeId",referencedColumnName = "computerTypeId")
    private ComputerType computerType;
    @ManyToOne
    @JoinColumn(name = "computerManufacturerId",referencedColumnName = "computerManufacturerId")
    private ComputerManufacturer computerManufacturer;
    @OneToMany(mappedBy = "computer",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<AccountComputer> accountComputers;
    public Computer() {
    }

    public Computer(Long computerId, String computerCode, String location, String configuration, String startUsedDate, String warrantyPeriod, int flagDelete, ComputerStatus computerStatus, ComputerType computerType, ComputerManufacturer computerManufacturer) {
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

    public void setStartUsedDate(String startUseDate) {
        this.startUsedDate = startUseDate;
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

    public void setComputerStatus(ComputerStatus computerStatus) {
        this.computerStatus = computerStatus;
    }

    public ComputerStatus getComputerStatus() {
        return computerStatus;
    }

    public Computer(ComputerStatus computerStatus) {
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

}

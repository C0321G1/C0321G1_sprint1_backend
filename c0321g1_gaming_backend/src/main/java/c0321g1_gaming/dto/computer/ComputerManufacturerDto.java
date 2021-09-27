package c0321g1_gaming.dto.computer;

public class ComputerManufacturerDto {
    private Long computerManufacturerId;
    private String name;

    public ComputerManufacturerDto() {
    }

    public ComputerManufacturerDto(Long computerManufacturerId, String name) {
        this.computerManufacturerId = computerManufacturerId;
        this.name = name;
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
}



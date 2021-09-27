package c0321g1_gaming.dto.computer;

public class ComputerTypeDto {
    private Long computerTypeId;
    private String name;

    public ComputerTypeDto() {
    }

    public ComputerTypeDto(Long computerTypeId, String name) {
        this.computerTypeId = computerTypeId;
        this.name = name;
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
}

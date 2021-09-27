package c0321g1_gaming.dto.computer;

public class ComputerStatusDto {
    private Long computerStatusId;
    private String name;


    public ComputerStatusDto() {
    }

    public ComputerStatusDto(Long computerStatusId, String name) {
        this.computerStatusId = computerStatusId;
        this.name = name;
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
}

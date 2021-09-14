package c0321g1_gaming.dto.services;
import c0321g1_gaming.model.entity.services.Unit;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ServicesDto {
    private Long servicesId;
    private String code;
    @NotNull(message = "Trường này không được để trống")
    @Min(value = 0,message = "Trường này phải lớn hơn 0")
    private int quantity;
    @NotNull( message = "Trường này không được để trống")
    @Min(value = 1000,message = "Trường này phải lớn hơn 1000")
    private int prices;
    @NotBlank(message = "Trường này không được để trống")
    private String name;
    private int flag;
    @NotBlank(message = "Trường này không được để trống")
    private String image;
    private Unit unit;

    public ServicesDto() {
    }

    public ServicesDto(Long servicesId, String code, @NotNull(message = "Trường này không được để trống") @Min(value = 0, message = "Trường này phải lớn hơn 0") int quantity, @NotNull(message = "Trường này không được để trống") @Min(value = 1000, message = "Trường này phải lớn hơn 1000") int prices, @NotBlank(message = "Trường này không được để trống") String name, int flag, @NotBlank(message = "Trường này không được để trống") String image, Unit unit) {
        this.servicesId = servicesId;
        this.code = code;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.flag = flag;
        this.image = image;
        this.unit = unit;
    }

    public ServicesDto(String code, int quantity, int prices, String name, int flag, String image, Unit unit) {
        this.code = code;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.flag = flag;
        this.image = image;
        this.unit = unit;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

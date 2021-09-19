package c0321g1_gaming.dto.services;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.services.Unit;

import javax.persistence.*;


public class ServicesDto {
    private Long servicesId;
    private int quantity;
    private int prices;
    private String name;
    private int flagDelete;
    private String image;
<<<<<<< HEAD
    private Unit unit;
    private Order order;
=======
    private Unit unitDto;
    private Order orderDto;
>>>>>>> origin

    public ServicesDto() {
    }

<<<<<<< HEAD
    public ServicesDto(Long servicesId, String code, @NotNull(message = "This field is not be blank") @Min(value = 0, message = "This field must be greater than 0") int quantity, @NotNull(message = "This field is not be blank") @Min(value = 1000, message = "This field must be greater than 1000") int prices, @NotBlank(message = "This field is not be blank") String name, int flag, @NotBlank(message = "This field is not be blank") String image, Unit unit, Order order) {
=======
    public ServicesDto(Long servicesId, int quantity, int prices, String name, int flagDelete, String image, Unit unitDto, Order orderDto) {
>>>>>>> origin
        this.servicesId = servicesId;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.flagDelete = flagDelete;
        this.image = image;
<<<<<<< HEAD
        this.unit = unit;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
    }

=======
        this.unitDto = unitDto;
        this.orderDto = orderDto;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
    }

>>>>>>> origin
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

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Unit getUnitDto() {
        return unitDto;
    }

    public void setUnitDto(Unit unitDto) {
        this.unitDto = unitDto;
    }

    public Order getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(Order orderDto) {
        this.orderDto = orderDto;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

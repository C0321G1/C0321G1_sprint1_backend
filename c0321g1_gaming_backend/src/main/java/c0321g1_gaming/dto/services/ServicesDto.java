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
    private Unit unitDto;
    private Order orderDto;

    public ServicesDto() {
    }

    public ServicesDto(Long servicesId, int quantity, int prices, String name, int flagDelete, String image, Unit unitDto, Order orderDto) {
        this.servicesId = servicesId;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.flagDelete = flagDelete;
        this.image = image;
        this.unitDto = unitDto;
        this.orderDto = orderDto;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
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
}

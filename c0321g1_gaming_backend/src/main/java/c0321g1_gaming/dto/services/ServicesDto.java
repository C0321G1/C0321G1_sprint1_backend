package c0321g1_gaming.dto.services;

import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.services.Unit;

import java.util.List;


public class ServicesDto {
    private Long servicesId;
    private String code;
    private int quantity;
    private int prices;
    private String name;
    private int flag;
    private String image;
    private Unit unit;
    private List<Order> orderList;

    public ServicesDto() {
    }

    public ServicesDto(Long servicesId, String code, int quantity, int prices, String name, int flag, String image, Unit unit, List<Order> orderList) {
        this.servicesId = servicesId;
        this.code = code;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.flag = flag;
        this.image = image;
        this.unit = unit;
        this.orderList = orderList;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}

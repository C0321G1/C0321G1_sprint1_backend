package c0321g1_gaming.model.entity.services;

import c0321g1_gaming.model.entity.order.OrderDetail;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicesId;
    private int quantity;
    private int prices;
    private String name;
    private String code;
    private int flag;
    private String image;
    @ManyToOne
    @JoinColumn(name = "unitId",referencedColumnName = "unitId")
    private Unit unit;
    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetail> ordersList;

    public Services() {
    }

    public Services(Long servicesId, int quantity, int prices, String name, String code, int flag, String image, Unit unit, List<OrderDetail> ordersList) {
        this.servicesId = servicesId;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.code = code;
        this.flag = flag;
        this.image = image;
        this.unit = unit;
        this.ordersList = ordersList;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<OrderDetail> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderDetail> ordersList) {
        this.ordersList = ordersList;
    }
}
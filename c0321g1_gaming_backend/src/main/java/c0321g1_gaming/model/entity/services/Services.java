package c0321g1_gaming.model.entity.services;

import c0321g1_gaming.model.entity.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private Unit unitDto;
    @OneToMany(mappedBy = "services", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Order> orderList;

    public Services() {
    }

    public Services(Long servicesId, int quantity, int prices, String name, String code, int flag, String image, Unit unitDto, List<Order> orderList) {
        this.servicesId = servicesId;
        this.quantity = quantity;
        this.prices = prices;
        this.name = name;
        this.code = code;
        this.flag = flag;
        this.image = image;
        this.unitDto = unitDto;
        this.orderList = orderList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Unit getUnitDto() {
        return unitDto;
    }

    public void setUnitDto(Unit unitDto) {
        this.unitDto = unitDto;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
        return unitDto;
    }

    public void setUnit(Unit unitDto) {
        this.unitDto = unitDto;
    }
}

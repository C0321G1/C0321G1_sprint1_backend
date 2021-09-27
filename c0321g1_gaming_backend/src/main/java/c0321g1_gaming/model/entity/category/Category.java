package c0321g1_gaming.model.entity.category;

import c0321g1_gaming.model.entity.security.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String description;
    private String discount;
    private String startTime;
    private String endTime;
    private String fee;
    private String type;

    @JsonBackReference
    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private Account account;

    public Category() {
    }

    public Category(Long categoryId, String description, String discount, String startTime, String endTime, String fee, String type, Account account) {
        this.categoryId = categoryId;
        this.description = description;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
        this.type = type;
        this.account = account;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

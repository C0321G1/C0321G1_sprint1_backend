package c0321g1_gaming.model.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerStatusId;
    private String name;
    @OneToMany(mappedBy = "customerStatus", cascade = CascadeType.ALL)
    @JsonBackReference(value = "customerStatus-customerList")
    private List<Customer> customerList;

    public CustomerStatus() {
    }

    public CustomerStatus(Long customerStatusId, String name, List<Customer> customerList) {
        this.customerStatusId = customerStatusId;
        this.name = name;
        this.customerList = customerList;
    }

    public Long getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(Long customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

package c0321g1_gaming.model.entity.address;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinceId;
    private String name;
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    @JsonBackReference(value = "province-addressList")
    private List<Address> addressList;

    public Province() {
    }

    public Province(String name, List<Address> addressList) {
        this.name = name;
        this.addressList = addressList;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}

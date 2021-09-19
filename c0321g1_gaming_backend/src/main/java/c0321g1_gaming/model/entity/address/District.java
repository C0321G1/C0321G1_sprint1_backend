package c0321g1_gaming.model.entity.address;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;
    private String name;
    @OneToMany(mappedBy = "district")
    @JsonBackReference
    private List<Address> addressList;

    public District() {
    }

    public District(String name, List<Address> addressList) {
        this.name = name;
        this.addressList = addressList;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
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

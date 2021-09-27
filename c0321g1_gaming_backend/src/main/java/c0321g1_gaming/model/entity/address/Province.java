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
    @JsonBackReference(value = "province-address")
    private List<Address> addressList;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    @JsonBackReference(value = "province-district")
    private List<District> districtList;

    public Province() {
    }

    public Province(Long provinceId, String name, List<Address> addressList, List<District> districtList) {
        this.provinceId = provinceId;
        this.name = name;
        this.addressList = addressList;
        this.districtList = districtList;
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

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }
}

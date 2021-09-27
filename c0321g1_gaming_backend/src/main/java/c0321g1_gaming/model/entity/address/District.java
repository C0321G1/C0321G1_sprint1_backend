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

    @ManyToOne
    @JoinColumn(name = "provinceId", referencedColumnName = "provinceId")
    private Province province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonBackReference(value = "district-address")
    private List<Address> addressList;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonBackReference(value = "district-commune")
    private List<Commune> communeList;

    public District() {
    }

    public District(Long districtId, String name, Province province, List<Address> addressList, List<Commune> communeList) {
        this.districtId = districtId;
        this.name = name;
        this.province = province;
        this.addressList = addressList;
        this.communeList = communeList;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Commune> getCommuneList() {
        return communeList;
    }

    public void setCommuneList(List<Commune> communeList) {
        this.communeList = communeList;
    }
}

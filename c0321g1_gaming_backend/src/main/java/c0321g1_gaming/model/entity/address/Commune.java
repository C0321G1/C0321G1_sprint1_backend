package c0321g1_gaming.model.entity.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communeId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "districtId", referencedColumnName = "districtId")
    private District district;

    @OneToMany(mappedBy = "commune")
    @JsonBackReference
    private List<Address> addressList;

    public Commune() {
    }

    public Commune(Long communeId, String name, District district, List<Address> addressList) {
        this.communeId = communeId;
        this.name = name;
        this.district = district;
        this.addressList = addressList;
    }

    public Long getCommuneId() {
        return communeId;
    }

    public void setCommuneId(Long communeId) {
        this.communeId = communeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}

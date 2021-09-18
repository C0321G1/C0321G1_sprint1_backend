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
    @OneToMany(mappedBy = "commune",cascade = CascadeType.ALL)
    @JsonBackReference(value ="commune")
    private List<Address> addressList;

    public Commune() {
    }

    public Commune(Long communeId, String name, List<Address> addressList) {
        this.communeId = communeId;
        this.name = name;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}

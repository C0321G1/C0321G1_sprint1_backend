package c0321g1_gaming.dto.address;

import c0321g1_gaming.model.entity.address.Address;

import java.util.List;


public class CommuneDto {

    private Long communeId;
    private String name;
    private List<Address> addressDtoList;

    public CommuneDto() {
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

    public List<Address> getAddressDtoList() {
        return addressDtoList;
    }

    public void setAddressDtoList(List<Address> addressDtoList) {
        this.addressDtoList = addressDtoList;
    }
}

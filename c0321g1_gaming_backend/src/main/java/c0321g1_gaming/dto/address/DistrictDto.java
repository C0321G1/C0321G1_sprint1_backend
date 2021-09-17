package c0321g1_gaming.dto.address;

import c0321g1_gaming.model.entity.address.Address;

import java.util.List;


public class DistrictDto {
    private Long districtId;
    private String name;
    private List<Address> addressDtoList;

    public DistrictDto() {
    }

    public DistrictDto(Long districtId, String name, List<Address> addressDtoList) {
        this.districtId = districtId;
        this.name = name;
        this.addressDtoList = addressDtoList;
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

    public List<Address> getAddressDtoList() {
        return addressDtoList;
    }

    public void setAddressDtoList(List<Address> addressDtoList) {
        this.addressDtoList = addressDtoList;
    }
}

package c0321g1_gaming.dto.address;

import c0321g1_gaming.model.entity.address.Address;

import java.util.List;


public class ProvinceDto {
    private Long provinceId;
    private String name;
    private List<Address> addressList;
    public ProvinceDto() {
    }

    public ProvinceDto(Long provinceId, String name, List<Address> addressList) {
        this.provinceId = provinceId;
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
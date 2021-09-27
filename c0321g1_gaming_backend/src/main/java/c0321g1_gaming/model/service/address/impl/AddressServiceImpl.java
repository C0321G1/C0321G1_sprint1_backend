package c0321g1_gaming.model.service.address.impl;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAddressList() {
        return addressRepository.getAddressList();
    }

    //    creator: vinhdn
    @Override
    public void save(Address address) {
        addressRepository.saveAddress(
                address.getProvince() == null ? null : address.getProvince().getProvinceId(),
                address.getDistrict() == null ? null : address.getDistrict().getDistrictId(),
                address.getCommune() == null ? null : address.getCommune().getCommuneId());
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.saveAddress(address.getProvince().getProvinceId(), address.getDistrict().getDistrictId(),
                address.getCommune().getCommuneId());
    }

    @Override
    public Long fileByAddressId(Address address) {
        List<Address> addressList = addressRepository.getAddressList();
        for (Address value : addressList) {
            boolean checkProvince = value.getProvince().getName().equals(address.getProvince().getName());
            boolean checkDistrict = value.getDistrict().getName().equals(address.getDistrict().getName());
            boolean checkCommune = value.getCommune().getName().equals(address.getCommune().getName());
            if (checkProvince && checkDistrict && checkCommune) {
                return value.getAddressId();
            }
        }
        return 0L;
    }
}

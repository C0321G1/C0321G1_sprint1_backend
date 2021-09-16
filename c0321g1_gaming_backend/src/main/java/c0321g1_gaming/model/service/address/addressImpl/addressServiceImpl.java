package c0321g1_gaming.model.service.address.addressImpl;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class addressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    //    creator: vinhdn
    @Override
    public void save(Address address) {
        addressRepository.saveAddress(
                address.getProvince() == null ? null : address.getProvince().getProvinceId(),
                address.getDistrict() == null ? null : address.getDistrict().getDistrictId(),
                address.getCommune() == null ? null : address.getCommune().getCommuneId());
    }
    //    creator: vinhdn
    @Override
    public List<Address> findAddressByQuery(Address address) {
        return null;
//        return addressRepository.findAddressByQuery(provinceId, districtId, communeId);
    }
    //    creator: vinhdn
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}

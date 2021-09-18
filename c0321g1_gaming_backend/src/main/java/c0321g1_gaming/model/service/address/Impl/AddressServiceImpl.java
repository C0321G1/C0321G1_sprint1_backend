package c0321g1_gaming.model.service.address.Impl;

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
    public Address searchAddress(Long province, Long district, Long commune) {
        return null;
    }

    @Override
    public List<Address> getAddressList() {
        return addressRepository.getAddressList();
    }

    @Override
    public void saveAddress(Address address) {

    }

    @Override
    public Long fileByAddressId(Address address) {
        return null;
    }


}

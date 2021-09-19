package c0321g1_gaming.model.service.address;

import c0321g1_gaming.model.entity.address.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address searchAddress(Long province,Long district,Long commune);

    List<Address> getAddressList();

    void saveAddress(Address address);

    Long fileByAddressId(Address address);
}

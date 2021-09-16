package c0321g1_gaming.model.service.address;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.security.Account;

import java.util.List;

public interface AddressService {
    //creator: vinhdn
    void save(Address address);

    //    creator: vinhdn
    List<Address> findAddressByQuery(Address address);

    //    creator: vinhdn
    List<Address> findAll();
}

package c0321g1_gaming.model.service.address;
import c0321g1_gaming.model.entity.address.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {
    List<Address> getAddressList();
    void saveAddress(Address address);

}

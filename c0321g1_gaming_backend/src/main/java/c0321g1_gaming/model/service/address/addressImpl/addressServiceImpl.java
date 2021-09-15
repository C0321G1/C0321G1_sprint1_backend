package c0321g1_gaming.model.service.address.addressImpl;

import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.security.Account;
import c0321g1_gaming.model.repository.address.AddressRepository;
import c0321g1_gaming.model.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    //    creator: vinhdn
    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
}

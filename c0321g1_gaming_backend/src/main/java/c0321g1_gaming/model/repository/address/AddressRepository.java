package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}

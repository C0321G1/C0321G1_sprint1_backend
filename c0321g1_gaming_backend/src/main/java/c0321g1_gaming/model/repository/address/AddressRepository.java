package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "select * from address", nativeQuery = true)
    List<Address> getAddressList();
}

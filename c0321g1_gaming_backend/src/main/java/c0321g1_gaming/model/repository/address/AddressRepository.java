package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "select * from address", nativeQuery = true)
    List<Address> getAddressList();

    @Query(value = "select address_id from address where commune_id=?1 and district_id=?2 and province_id=?1",nativeQuery = true)
    Address searchAddress(Long province,Long district,Long commune);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO address (province_id, district_id, commune_id)" +
            "VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveAddress(Long provinceId, Long districtId, Long communeId);

}

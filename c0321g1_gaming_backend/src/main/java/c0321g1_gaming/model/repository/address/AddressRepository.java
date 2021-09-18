package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    //    creator: vinhdn
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO address (province_id, district_id, commune_id)" +
            "VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveAddress(Long provinceId, Long districtId, Long communeId);

    //    creator: vinhdn
    @Query(value = "select * from address", nativeQuery = true)
    List<Address> findAllQuery();
}

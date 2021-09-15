package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DistrictRepository extends JpaRepository<District, Long> {
    @Query(value="select * from district", nativeQuery = true)
    List<District> getDistrictList();

}

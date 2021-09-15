package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    @Query(value="select * from province", nativeQuery = true)
    List<Province> getProvinceList();

}

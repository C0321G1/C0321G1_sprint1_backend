package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.entity.address.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
    //creator: vinhdn
    @Query(value = "select * from province", nativeQuery = true)
    List<Province> findAllQuery();
}

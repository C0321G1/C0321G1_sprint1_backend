package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
}

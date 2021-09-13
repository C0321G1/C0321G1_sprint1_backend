package c0321g1_gaming.model.repository.gender;

import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.entity.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Long> {

    @Query(value="select * from gender", nativeQuery = true)
    List<Gender> getGenderList();
}

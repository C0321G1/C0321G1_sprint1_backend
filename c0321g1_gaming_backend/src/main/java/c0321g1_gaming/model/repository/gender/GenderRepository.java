package c0321g1_gaming.model.repository.gender;

import c0321g1_gaming.model.entity.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    //creator: vinhdn
    @Query(value = "select * from gender", nativeQuery = true)
    List<Gender> findAllQuery();
}

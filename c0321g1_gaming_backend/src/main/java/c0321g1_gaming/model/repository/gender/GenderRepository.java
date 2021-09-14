package c0321g1_gaming.model.repository.gender;

import c0321g1_gaming.model.entity.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Long> {
}

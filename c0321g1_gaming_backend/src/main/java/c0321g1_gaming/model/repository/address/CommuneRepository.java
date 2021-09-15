package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommuneRepository extends JpaRepository<Commune,Long> {
    @Query(value="select * from commune", nativeQuery = true)
    List<Commune> getCommuneList();
}

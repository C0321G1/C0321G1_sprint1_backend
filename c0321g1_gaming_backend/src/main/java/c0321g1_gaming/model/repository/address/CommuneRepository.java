package c0321g1_gaming.model.repository.address;

import c0321g1_gaming.model.entity.address.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {
    //creator: vinhdn
    @Query(value = "select * from commune", nativeQuery = true)
    List<Commune> findAllQuery();
}

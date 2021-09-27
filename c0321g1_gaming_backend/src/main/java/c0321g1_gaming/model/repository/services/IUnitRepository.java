package c0321g1_gaming.model.repository.services;

import c0321g1_gaming.model.entity.services.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUnitRepository extends JpaRepository<Unit,Long> {
    @Query(value = "select * from unit ",nativeQuery = true)
    List<Unit> findAllUnit();
}
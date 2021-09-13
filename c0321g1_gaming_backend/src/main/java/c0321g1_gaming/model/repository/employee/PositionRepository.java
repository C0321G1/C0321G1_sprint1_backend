package c0321g1_gaming.model.repository.employee;


import c0321g1_gaming.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PositionRepository extends JpaRepository<Position,Long> {
    @Query(value="select * from position", nativeQuery = true)
    List<Position> getPositionList();
}

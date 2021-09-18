package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ComputerStatusRepository extends JpaRepository<ComputerStatus, Long> {
    @Query(value = "SELECT * FROM Computer_Status", nativeQuery = true)
    List<ComputerStatus> findAll();

    @Query(value = "SELECT * FROM Computer_Status where `name` =?1", nativeQuery = true)
    ComputerStatus findByName(String name);
}

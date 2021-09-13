package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerStatusRepository extends JpaRepository<ComputerStatus, Long> {
}

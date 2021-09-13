package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerTypeRepository extends JpaRepository<ComputerType, Long> {
}

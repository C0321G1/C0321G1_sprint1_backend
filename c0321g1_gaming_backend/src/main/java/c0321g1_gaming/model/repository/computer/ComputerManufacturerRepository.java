package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerManufacturerRepository extends JpaRepository<ComputerManufacturer, Integer> {
}

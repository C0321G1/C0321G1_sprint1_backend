package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}

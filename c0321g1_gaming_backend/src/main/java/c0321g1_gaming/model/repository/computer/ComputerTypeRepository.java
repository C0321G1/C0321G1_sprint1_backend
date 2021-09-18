package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComputerTypeRepository extends JpaRepository<ComputerType, Long> {
    @Query(value = "SELECT * FROM Computer_Type", nativeQuery = true)
    List<ComputerType> findAll();

    @Query(value = "SELECT * FROM Computer_Type where `name` =?1", nativeQuery = true)
    ComputerType findByName(String name);
}

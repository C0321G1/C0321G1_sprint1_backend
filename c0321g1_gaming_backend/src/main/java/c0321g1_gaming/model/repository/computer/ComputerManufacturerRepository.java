package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ComputerManufacturerRepository extends JpaRepository<ComputerManufacturer, Integer> {
    @Query(value = "SELECT * FROM Computer_Manufacturer", nativeQuery = true)
    List<ComputerManufacturer> findAll();

    @Query(value = "SELECT * FROM Computer_Manufacturer where `name` =?1", nativeQuery = true)
    ComputerManufacturer findByName(String name);
}

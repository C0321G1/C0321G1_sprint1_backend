package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    Page<Computer> getAllComputer(Pageable pageable);

    List<Computer> findAll();

    Page<Computer> searchComputer(String computerId, String location, Pageable pageable);

    Optional<Computer> findComputerById(Long id);

    void deleteComputer(Computer computer);

    void saveComputer(Computer computer);


}

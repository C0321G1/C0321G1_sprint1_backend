package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    Page<Computer> getAllComputer(Pageable pageable);

    List<Computer> findAll();

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  String startDateFrom, String startDateTo, Pageable pageable);

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  Pageable pageable);

    Optional<Computer> findComputerById(Long id);

    void deleteComputer(Computer computer);
<<<<<<< HEAD
=======

    void saveComputer(Computer computer);
<<<<<<< HEAD


=======
>>>>>>> ad036e4404c162616be0aa423a3b79bf1857d2f5
>>>>>>> 4c33b42bec80e48e30fa4996029058d3ed9d4909
}

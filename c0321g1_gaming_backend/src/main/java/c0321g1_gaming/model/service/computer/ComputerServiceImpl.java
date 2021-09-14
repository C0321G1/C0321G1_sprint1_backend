package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.repository.computer.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    ComputerRepository computerRepository;

    @Override
    public Page<Computer> getAllComputer(Pageable pageable) {
        return computerRepository.findAllComputer(pageable);
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                         String startDateFrom, String startDateTo, Pageable pageable) {
        computerId = "%" + computerId + "%";
        location = "%" + location + "%";
        computerType = "%" + computerType + "%";
        computerStatus = "%" + computerStatus + "%";
        return computerRepository.searchComputer(computerId, location, computerType, computerStatus, startDateFrom,
                startDateTo, pageable);
    }

    @Override
    public Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                         Pageable pageable) {
        computerId = "%" + computerId + "%";
        location = "%" + location + "%";
        computerType = "%" + computerType + "%";
        computerStatus = "%" + computerStatus + "%";
        return computerRepository.searchComputer(computerId, location, computerType, computerStatus, pageable);
    }

    @Override
    public Optional<Computer> findComputerById(Long id) {
        return computerRepository.findComputerById(id);
    }

    @Override
    public void deleteComputer(Computer computer) {
        computerRepository.delete(computer);
    }

    @Override
    public void saveComputer(Computer computer) {
        computerRepository.save(computer);
    }


}

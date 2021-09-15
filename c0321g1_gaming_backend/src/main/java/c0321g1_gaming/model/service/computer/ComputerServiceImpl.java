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
    public void createComputer(String computer_code, String location, String start_used_date,
                               String configuration, String warranty_period, Integer flag_delete,
                               Long id_type, Long id_manufacturer, Long id_status) {
        computerRepository.createComputer(computer_code, location, start_used_date, configuration,
                warranty_period, flag_delete, id_type, id_manufacturer, id_status);
    }

    @Override
    public void updateComputer(String computer_code, String location, String start_used_date,
                               String configuration, String warranty_period, Long id_type,
                               Long id_manufacturer, Long id_status, Long computer_id) {
        computerRepository.updateComputer(computer_code, location, start_used_date, configuration, warranty_period,
                id_type, id_manufacturer, id_status, computer_id);
    }

    @Override
    public Computer searchComputerCode(String computerCode) {
        return computerRepository.searchComputerCode(computerCode);
    }


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
    public void saveComputer(Computer computer) {
        computerRepository.save(computer);
    }

    /*@Override
    public void setComputerStatus(Long id) {
        Optional<Computer> computer = computerRepository.findComputerById(id);
        if(computer.get().getComputerStatus().getComputerStatusId() != 1){
            computerRepository.updateStatus(id, 1);
        }else {
            computerRepository.updateStatus(id, 2);
        }
    }*/

}
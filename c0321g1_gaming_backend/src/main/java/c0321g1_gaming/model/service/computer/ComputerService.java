package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ComputerService {

    /*long-computer*/
    void createComputer(String computerCode,String location,String startUsedDate,
                        String configuration,String warrantyPeriod,Integer flagDelete,
                        Long idType,Long idManufacturer,Long idStatus);
    void updateComputer(String computerCode,String location,String startUsedDate,
                        String configuration,String warrantyPeriod,
                        Long idType,Long idManufacturer,Long idStatus,Long computerId);

    /*nguyen-computer*/
    Computer searchComputerCode(String computerCode);

    Page<Computer> getAllComputer(Pageable pageable);

    List<Computer> findAll();

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  String startDateFrom, String startDateTo, Pageable pageable);

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  Pageable pageable);

    Optional<Computer> findComputerById(Long id);

    void deleteComputer(Computer computer);

    void saveComputer(Computer computer);

    void setComputerStatus(Long id);
}

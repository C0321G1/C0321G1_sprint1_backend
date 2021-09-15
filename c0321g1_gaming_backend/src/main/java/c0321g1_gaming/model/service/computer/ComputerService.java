package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ComputerService {

    /*long-computer*/
    void createComputer(String computer_code,String location,String start_used_date,
                        String configuration,String warranty_period,Integer flag_delete,
                        Long id_type,Long id_manufacturer,Long id_status);
    void updateComputer(String computer_code,String location,String start_used_date,
                        String configuration,String warranty_period,
                        Long id_type,Long id_manufacturer,Long id_status,Long computer_id);

    /*nguyen-computer*/
    Computer searchComputerCode(String computerCode);

    Page<Computer> getAllComputer(Pageable pageable);

    List<Computer> findAll();

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  String startDateFrom, String startDateTo, Pageable pageable);

    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  Pageable pageable);

    Optional<Computer> findComputerById(Long id);

    void saveComputer(Computer computer);

    /*void setComputerStatus(Long id);*/

}

package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    @Query(value = "SELECT * FROM Computer WHERE computer.flag_delete=0", nativeQuery = true)
    Page<Computer> findAllComputer(Pageable pageable);

    @Query(value = "SELECT * FROM Computer WHERE computer.computer_id=?1", nativeQuery = true)
    Optional<Computer> findComputerById(Long id);

    @Query(value = "select * from Computer " +
            "inner join computer_type on computer.computer_type_id = computer_type.computer_type_id " +
            "inner join computer_status on computer.computer_status_id = computer_status.computer_status_id " +
            "where ((computer_code like ?1) and (location like ?2) and (computer_type.name like ?3) " +
            "and (computer_status.name like ?4)) and (start_used_date between ?5 and ?6) and flag_delete = 0", nativeQuery = true)
    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  String startDateFrom, String startDateTo, Pageable pageable);

    @Query(value = "select * from Computer " +
            "inner join computer_type on computer.computer_type_id = computer_type.computer_type_id " +
            "inner join computer_status on computer.computer_status_id = computer_status.computer_status_id " +
            "where ((computer_code like ?1) and (location like ?2) and (computer_type.name like ?3) " +
            "and (computer_status.name like ?4)) and flag_delete = 0", nativeQuery = true)
    Page<Computer> searchComputer(String computerId, String location, String computerType, String computerStatus,
                                  Pageable pageable);

}

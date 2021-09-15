package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    @Modifying
    @Query(value = "INSERT INTO computer (computer_code,location,start_used_date,configuration,warranty_period,\n" +
            "            flag_delete,computer_type_id,computer_manufacturer_id,computer_status_id)\n" +
            "VALUES (:computer_code,:location,:start_used_date,:configuration,:warranty_period,\n" +
            "            :flag_delete,:id_type,:id_manufacturer,:id_status);", nativeQuery = true)
    @Transactional
    Integer createComputer(@Param("computer_code") String computer_code,
                           @Param("location") String location,
                           @Param("start_used_date") String start_used_date,
                           @Param("configuration") String configuration,
                           @Param("warranty_period") String warranty_period,
                           @Param("flag_delete") Integer flag_delete,
                           @Param("id_type") Long id_type,
                           @Param("id_manufacturer") Long id_manufacturer,
                           @Param("id_status") Long id_status);

    @Modifying
    @Query(value = "update computer \n" +
            "set computer_code = :computer_code,location = :location,start_used_date = :start_used_date," +
            "configuration = :configuration,warranty_period = :warranty_period,\n" +
            "computer_type_id = :id_type,computer_manufacturer_id = :id_manufacturer,computer_status_id = :id_status\n" +
            "where computer_id =:computer_id", nativeQuery = true)
    @Transactional
    Integer updateComputer(@Param("computer_code") String computer_code,
                           @Param("location") String location,
                           @Param("start_used_date") String start_used_date,
                           @Param("configuration") String configuration,
                           @Param("warranty_period") String warranty_period,
                           @Param("id_type") Long id_type,
                           @Param("id_manufacturer") Long id_manufacturer,
                           @Param("id_status") Long id_status,
                           @Param("computer_id") Long computer_id);

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
    @Query(value="select * from computer where computer.computer_code = ?1",nativeQuery = true)
    Computer searchComputerCode(String computerCode);
}

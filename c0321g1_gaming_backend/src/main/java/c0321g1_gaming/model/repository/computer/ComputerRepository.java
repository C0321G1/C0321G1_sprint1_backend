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
            "VALUES (:computerCode,:location,:startUsedDate,:configuration,:warrantyPeriod,\n" +
            "            :flagDelete,:idType,:idManufacturer,:idStatus);", nativeQuery = true)
    @Transactional
    Integer createComputer(@Param("computerCode") String computerCode,
                           @Param("location") String location,
                           @Param("startUsedDate") String startUsedDate,
                           @Param("configuration") String configuration,
                           @Param("warrantyPeriod") String warrantyPeriod,
                           @Param("flagDelete") Integer flagDelete,
                           @Param("idType") Long idType,
                           @Param("idManufacturer") Long idManufacturer,
                           @Param("idStatus") Long idStatus);

    @Modifying
    @Query(value = "update computer \n" +
            "set computer_code = :computerCode,location = :location,start_used_date = :startUsedDate," +
            "configuration = :configuration,warranty_period = :warrantyPeriod,\n" +
            "computer_type_id = :idType,computer_manufacturer_id = :idManufacturer,computer_status_id = :idStatus\n" +
            "where computer_id =:computerId", nativeQuery = true)
    @Transactional
    Integer updateComputer(@Param("computerCode") String computerCode,
                           @Param("location") String location,
                           @Param("startUsedDate") String startUsedDate,
                           @Param("configuration") String configuration,
                           @Param("warrantyPeriod") String warrantyPeriod,
                           @Param("idType") Long idType,
                           @Param("idManufacturer") Long idManufacturer,
                           @Param("idStatus") Long idStatus,
                           @Param("computerId") Long computerId);

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

    @Transactional
    @Modifying
    @Query(value = "update computer " +
            "set flag_delete = 1 " +
            "where computer_id = ?1 ", nativeQuery = true)
    void deleteComputer(int id);

    @Transactional
    @Modifying
    @Query(value = "update computer " +
            "set computer_status_id = 1 " +
            "where computer_id = ?1 ", nativeQuery = true)
    void setComputerStatusOnline(int id);

    @Transactional
    @Modifying
    @Query(value = "update computer " +
            "set computer_status_id = 2 " +
            "where computer_id = ?1 ", nativeQuery = true)
    void setComputerStatusOffline(int id);
}
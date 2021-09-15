package c0321g1_gaming.model.repository.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface ComputerRepository extends JpaRepository<Computer, Long> {
    @Query(value = "SELECT * FROM Computer WHERE computer.flag_delete=0", nativeQuery = true)
    Page<Computer> findAllComputer(Pageable pageable);

/*long-computer*/
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
/*long-computer*/
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

    @Query(value="select * from computer where computer.computer_code = ?1",nativeQuery = true)
    Computer searchComputerCode(String computerCode);
}

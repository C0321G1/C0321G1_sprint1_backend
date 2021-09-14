package c0321g1_gaming.model.repository.employee;

import c0321g1_gaming.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // khue create query get list employee
    @Query(value= "select * from employee " +
            "where flag_del = 0 ", nativeQuery = true)
    Page<Employee> getListEmployee(Pageable pageable);

    // khue create query delete employee
    @Transactional
    @Modifying
    @Query(value = "update employee " +
            "set flag_del = 1 " +
            "where employee_id = ?1 ", nativeQuery = true)
    void deleteEmployee(int id);

    // khue create method query search employee
    @Query(value = "SELECT employee.employee_id, employee.code, employee.date_of_birth, employee.email," +
            "  employee.flag_del, employee.image, employee.level, employee.full_name,employee.phone," +
            "  employee.start_work_date, employee.year_of_exp, employee.account_id," +
            "  employee.address_id, employee.gender_id, employee.position_id" +
            "   FROM `employee` " +
            "join `position` on `employee`.position_id = `position`.position_id " +
            "join address on employee.address_id = address.address_id " +
            "join province on address.province_id = province.province_id " +
            "where employee.code like %?1% and (employee.date_of_birth between ?2 and ?3) " +
            "and (employee.start_work_date between ?4 and ?5 ) and position.name like %?6% " +
            "and province.name like %?7% and employee.flag_del = 0", nativeQuery = true)
    Page<Employee> searchEmployee(Pageable pageable,String employeeId, String dateBirthFrom,
                                  String dateBirthTo, String dateWorkFrom, String dateWorkTo,
                                  String position, String province);

}

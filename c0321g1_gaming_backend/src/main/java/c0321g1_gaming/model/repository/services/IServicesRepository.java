package c0321g1_gaming.model.repository.services;

import c0321g1_gaming.model.entity.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IServicesRepository extends JpaRepository<Services, Long> {
    @Query(value = " select * from services where concat(code,`name`,prices) like ?1 and flag = 1 ", nativeQuery = true,
            countQuery = "select count(*) from services where concat(code,`name`,prices) like ?1 and flag = 1 ")
    Page<Services> pageServicesAll(String name, Pageable pageable);

    @Query(value = "select * from services where (code like ?1 ) and ( `name` like ?2 ) and (prices like ?3 ) and flag = 1", nativeQuery = true,
            countQuery = "select count(*) from services where (code like ?1 ) and ( `name` like ?2 ) and (prices like ?3 ) and flag = 1")
    Page<Services> pageServicesCodeNamePrices(String code, String name, String prices, Pageable pageable);


    @Query(value = "delete from services where (services_id = ?1 )", nativeQuery = true)
    void deleteServicesId(Long id);

    @Query(value = "select * from services where (services_id = ?1) and flag = 1", nativeQuery = true)
    Services findByIdServices(Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into services (`code`, `flag`, `image`, `name`, `prices`, `quantity`, `unit_id`)" +
            "value ( ?1 , ?2 , ?3 , ?4 ,?5 ,?6, ?7)", nativeQuery = true)
    void saveServices(String code, int flag, String image, String name, double prices, int quantity, int unitId);

    @Modifying
    @Transactional
    @Query(value =" UPDATE services " +
            "set code =?1,flag = ?2,image = ?3,name=?4,prices=?5,quantity=?6,unit_id=?7 where services.services_id = ?8" , nativeQuery = true)
    void updateServices(String code, int flag, String image, String name, double prices, int quantity, int unitId,Long servicesId);

}

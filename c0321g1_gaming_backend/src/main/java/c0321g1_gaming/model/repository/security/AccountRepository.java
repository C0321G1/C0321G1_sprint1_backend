package c0321g1_gaming.model.repository.security;

import c0321g1_gaming.model.entity.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Auhor: Dong
     * method: saveAccountDto,updateAccountDto
     */

    @Modifying
    @Transactional
    @Query(value="INSERT INTO `account`(`username`,`password`) VALUES(?1,?2)",nativeQuery = true)
    void saveAccountDto(String username,String password);

    @Modifying
    @Transactional
    @Query(value="update `account` set`password`=?1 where `username`=?2",nativeQuery = true)
    void updateAccountDto(String password,String username);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO address (province_id, district_id, commune_id)" +
            "VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveAddress(Long provinceId, Long districtId, Long communeId);
}

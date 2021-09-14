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
    @Query(value="update `account` set`password`=?1, where `username`=?2",nativeQuery = true)
    Integer updateAccountDto(String password,String username);

}

package c0321g1_gaming.model.repository.game;

import c0321g1_gaming.model.entity.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface IGameRepository extends JpaRepository<Game, Long> {
    // Creator: Nhung

    @Query(value = "SELECT game_id,`name`,content,image,gaming,trailer,game_type_id,flag_delete FROM game WHERE game_id = ?;", nativeQuery = true)
    Optional<Game> findById(Long gameId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO game(`name`,content,image,gaming,trailer,game_type_id,flag_delete) VALUES (?1,?2,?3,?4,?5,?6,?7);", nativeQuery = true)
    void saveGame(String name, String content, String image, String gaming, String trailer, Long gameTypeId, int flagDelete);

    @Modifying
    @Transactional
    @Query(value ="UPDATE game " +
            "set `name` =?1,content = ?2,image = ?3,gaming=?4,trailer=?5,game_type_id=?6,flag_delete=?7 where game.game_id = ?8" , nativeQuery = true)
    void updateGame(String name, String content, String image, String gaming, String trailer, Long gameTypeId,int flagDelete, Long gameId);

}

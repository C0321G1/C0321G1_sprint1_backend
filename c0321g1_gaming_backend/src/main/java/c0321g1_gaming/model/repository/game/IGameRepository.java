package c0321g1_gaming.model.repository.game;

import c0321g1_gaming.model.entity.game.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
    @Query(value = "UPDATE game " +
            "set `name` =?1,content = ?2,image = ?3,gaming=?4,trailer=?5,game_type_id=?6,flag_delete=?7 where game.game_id = ?8", nativeQuery = true)
    void updateGame(String name, String content, String image, String gaming, String trailer, Long gameTypeId, int flagDelete, Long gameId);

    //    Creator: Thúy
    @Query(value = "SELECT game.game_id, game.`name`, game.content, game.image, game.gaming, game.trailer, game.flag_delete, game_type.`name` " +
            "FROM game " +
            "join game_type on game.game_type_id = game_type.game_type_id " +
            "WHERE game.flag_delete = 0;", nativeQuery = true)
    Page<Game> getAllGame(Pageable pageable);

    @Query(value = "SELECT game.game_id, game.`name`, game.content, game.image, game.gaming, game.trailer, game.flag_delete, game_type.`name` " +
            "FROM game " +
            "join game_type on game.game_type_id = game_type.game_type_id " +
            "WHERE ( game.name like ?1 ) and (game_type.name like ?2 ) and game.flag_delete = 0", nativeQuery = true)
    Page<Game> getGameBySearching(Pageable pageable, String name, String gameType);

    @Transactional
    @Modifying
    @Query(value = "UPDATE game SET flag_delete = 1  WHERE game_id = ?1 ", nativeQuery = true)
    void deleteGameFlag(Long gameId);
}

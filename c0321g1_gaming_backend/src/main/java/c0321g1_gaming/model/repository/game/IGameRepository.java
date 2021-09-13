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

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO game(`name`,content,image,gaming,trailer,game_type_id,flag_delete) VALUES (?1,?2,?3,?4,?5,?6,?7);", nativeQuery = true)
    void saveGame(String name, String content, String image, String gaming, String trailer, Long gameTypeId, int flagDelete);

    @Transactional
    @Modifying
    @Query(value = "UPDATE game SET (`name` =?1, content =?2, image =?3, gaming =?4, trailer =?5, game_type_id =?6) WHERE game_id = ?7;", nativeQuery = true)
    void updateGame(String name, String content, String image, String gaming, String trailer, Long gameTypeId, Long gameId);

    @Query(value = "SELECT game_id,`name`,content,image,gaming,trailer,game_type_id,flag_delete FROM game WHERE game_id = ?;", nativeQuery = true)
    Optional<Game> findById(Long gameId);
//
//    //Create : Thúy
//
//    @Query(value = "select * from game " +
//            "join game_type on game.game_type_id = game_type.game_type_id " +
//            "where ( game.name like ?1 ) and (game_type.name like ?2 ) and game.flag_delete = 0", nativeQuery = true)
//    List<Game> getGameBySearchingName(String name, String gameType);
}

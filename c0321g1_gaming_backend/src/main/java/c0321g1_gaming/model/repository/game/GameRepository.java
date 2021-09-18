package c0321g1_gaming.model.repository.game;

import c0321g1_gaming.model.entity.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "select * from game " +
            "join game_type on game.game_type_id = game_type.game_type_id " +
            "where ( game.name like ?1 ) and (game_type.name like ?2 ) and game.flag_delete = 0", nativeQuery = true)
    List<Game> getGameBySearchingName(String name, String gameType);
}

package c0321g1_gaming.model.repository.game;

import c0321g1_gaming.model.entity.game.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGameTypeRepository extends JpaRepository<GameType, Long> {
    @Query(value = "select game_type_id,`name` from game_type", nativeQuery = true)
    List<GameType> findAll();
}

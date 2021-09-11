package c0321g1_gaming.model.repository.game;

import c0321g1_gaming.model.entity.game.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTypeRepository extends JpaRepository<GameType, Long> {
}

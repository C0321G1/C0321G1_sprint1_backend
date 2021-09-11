package c0321g1_gaming.model.service.game;

import c0321g1_gaming.model.entity.game.Game;

import java.util.Optional;

public interface GameService {
    // Nhung
    Optional<Game> findById(Long id);

    Game save(Game game);
}

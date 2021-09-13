package c0321g1_gaming.model.service.game;

import c0321g1_gaming.model.entity.game.Game;

public interface IGameService {
    // Creator: Nhung
    Game findById(Long id);

    void saveGame(Game game);

    void updateGame(Game game);
}

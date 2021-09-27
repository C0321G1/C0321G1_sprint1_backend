package c0321g1_gaming.model.service.game;

import c0321g1_gaming.model.entity.game.GameType;

import java.util.List;

public interface IGameTypeService {
    List<GameType> findAll();
}

package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.repository.game.IGameRepository;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements IGameService {
    @Autowired
    private IGameRepository gameRepository;

    // Creator: Nhung

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public void saveGame(Game game) {
        gameRepository.saveGame(game.getName(),game.getContent(),game.getImage(),game.getGaming(),game.getTrailer(),game.getGameType().getGameTypeId(),game.getFlagDelete());
    }

    @Override
    public void updateGame(Game game) {
        gameRepository.updateGame(game.getName(),game.getContent(),game.getImage(),game.getGaming(),game.getTrailer(),game.getGameType().getGameTypeId(),game.getGameId());

    }
}

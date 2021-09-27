package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.repository.game.IGameRepository;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements IGameService {
    @Autowired
    private IGameRepository gameRepository;

// Creator: Nhung

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public void saveGame(Game game) {
        gameRepository.saveGame(game.getName().trim(), game.getContent().trim(), game.getImage(), game.getGaming(), game.getTrailer().trim(), game.getGameType().getGameTypeId(), game.getFlagDelete());
    }

    @Override
    public void updateGame(Game game) {
        gameRepository.updateGame(game.getName().trim(), game.getContent().trim(), game.getImage(), game.getGaming(), game.getTrailer().trim(), game.getGameType().getGameTypeId(), game.getGameId());
    }

    //    Creator: Thúy
    @Override
    public Page<Game> getAllGame(Pageable pageable) {
        return gameRepository.getAllGame(pageable);
    }

    @Override
    public Page<Game> getGameBySearching(Pageable pageable, String name, String gameType) {
        return gameRepository.getGameBySearching(pageable, "%" + name + "%", "%" + gameType + "%");
    }

    @Override
    public void deleteGameFlag(Long gameId) {
        gameRepository.deleteGameFlag(gameId);
    }

    @Override
    public List<Game> searchTopGame() {
        return gameRepository.searchTopGame();
    }
}
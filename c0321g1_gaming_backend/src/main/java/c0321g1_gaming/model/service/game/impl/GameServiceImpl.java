package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.repository.game.GameRepository;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements IGameService {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

//    Creator: Thúy
//    @Override
//    public void delete(Long id) {
//        gameRepository.deleteById(id);
//    }

    @Override
    public List<Game> getGameBySearchingName(String name, String gameType) {
        return gameRepository.getGameBySearchingName("%" + name + "%", "%" + gameType + "%");
    }
}

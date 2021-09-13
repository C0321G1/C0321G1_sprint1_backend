package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.Game;
import c0321g1_gaming.model.repository.game.IGameRepository;
import c0321g1_gaming.model.service.game.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements IGameService {
    @Autowired
    private IGameRepository gameRepository;
<<<<<<< HEAD
=======

    // Creator: Nhung
>>>>>>> 0b8414ec1c4ed7639a0495a897a215e388a37542

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public void saveGame(Game game) {
        gameRepository.saveGame(game.getName(), game.getContent(), game.getImage(), game.getGaming(), game.getTrailer(), game.getGameType().getGameTypeId(), game.getFlagDelete());
    }

    @Override
    public void updateGame(Game game) {
        gameRepository.updateGame(game.getName(), game.getContent(), game.getImage(), game.getGaming(), game.getTrailer(), game.getGameType().getGameTypeId(), game.getGameId());

    }

//    Creator: Thúy
<<<<<<< HEAD
    @Override
    public List<Game> getGameBySearchingName(String name, String gameType) {
        return gameRepository.getGameBySearchingName("%" + name + "%", "%" + gameType + "%");
    }
=======
//    @Override
//    public void delete(Long id) {
//        gameRepository.deleteById(id);
//    }

//    @Override
//    public List<Game> getGameBySearchingName(String name, String gameType) {
//        return gameRepository.getGameBySearchingName("%" + name + "%", "%" + gameType + "%");
//    }
>>>>>>> 0b8414ec1c4ed7639a0495a897a215e388a37542
}

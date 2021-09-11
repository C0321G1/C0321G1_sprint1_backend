package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.GameType;
import c0321g1_gaming.model.repository.game.GameTypeRepository;
import c0321g1_gaming.model.service.game.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTypeServiceImpl implements GameTypeService {
    @Autowired
    private GameTypeRepository gameTypeRepository;

    @Override
    public List<GameType> findAll() {
        return gameTypeRepository.findAll();
    }
}

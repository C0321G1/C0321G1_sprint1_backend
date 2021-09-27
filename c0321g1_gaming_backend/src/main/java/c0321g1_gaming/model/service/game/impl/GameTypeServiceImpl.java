package c0321g1_gaming.model.service.game.impl;

import c0321g1_gaming.model.entity.game.GameType;
import c0321g1_gaming.model.repository.game.IGameTypeRepository;
import c0321g1_gaming.model.service.game.IGameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTypeServiceImpl implements IGameTypeService {
    @Autowired
    private IGameTypeRepository gameTypeRepository;

    @Override
    public List<GameType> findAll() {
        return gameTypeRepository.findAll();
    }
}

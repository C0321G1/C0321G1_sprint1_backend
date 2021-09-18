package c0321g1_gaming.dto.game;

import c0321g1_gaming.model.entity.game.Game;

import java.util.List;


public class GameTypeDto {
    private Long gameTypeId;
    private String name;

    private List<Game> gameList;


    public GameTypeDto() {
    }

    public GameTypeDto(Long gameTypeId, String name, List<Game> gameList) {
        this.gameTypeId = gameTypeId;
        this.name = name;
        this.gameList = gameList;
    }

    public Long getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(Long gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}

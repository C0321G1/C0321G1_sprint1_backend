package c0321g1_gaming.dto.game;

import c0321g1_gaming.model.entity.game.Game;

import java.util.List;


public class GameTypeDto {
    private Long gameTypeId;
    private String name;
    private List<Game> gameDtoList;

    public GameTypeDto() {
    }

    public GameTypeDto(Long gameTypeId, String name, List<Game> gameDtoList) {
        this.gameTypeId = gameTypeId;
        this.name = name;
        this.gameDtoList = gameDtoList;
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

    public List<Game> getGameDtoList() {
        return gameDtoList;
    }

    public void setGameDtoList(List<Game> gameDtoList) {
        this.gameDtoList = gameDtoList;
    }
}

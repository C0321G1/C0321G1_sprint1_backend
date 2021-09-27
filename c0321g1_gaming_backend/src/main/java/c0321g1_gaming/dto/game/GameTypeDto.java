package c0321g1_gaming.dto.game;


public class GameTypeDto {
    private int gameTypeId;
    private String name;

    public GameTypeDto() {
    }

    public GameTypeDto(int gameTypeId, String name) {
        this.gameTypeId = gameTypeId;
        this.name = name;
    }

    public int getGameTypeId() {
        return gameTypeId;
    }

    public void setGameTypeId(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
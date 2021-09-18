package c0321g1_gaming.dto.game;


import c0321g1_gaming.model.entity.game.GameType;

public class GameDto {
    private Long gameId;
    private String content;
    private int flagDelete;
    private String name;
    private String image;
    private String gaming;
    private String trailer;
    private GameType gameType;


    public GameDto() {
    }


    public GameDto(Long gameId, String content, int flagDelete, String name, String image, String gaming,
                   String trailer, GameType gameType) {
        this.gameId = gameId;
        this.content = content;
        this.flagDelete = flagDelete;
        this.name = name;
        this.image = image;
        this.gaming = gaming;
        this.trailer = trailer;
        this.gameType = gameType;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(int flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGaming() {
        return gaming;
    }

    public void setGaming(String gaming) {
        this.gaming = gaming;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}

package c0321g1_gaming.dto.game;


import c0321g1_gaming.model.entity.game.GameType;

import javax.validation.constraints.*;

public class GameDto {
    private Long gameId;
    @NotBlank(message = "Content is required")
    @Size(max = 2007,message = "Content cannot be longer than 2000 characters")
    private String content;
    @NotNull
    private int flagDelete;
    @NotBlank(message = "Flag Delete is required")
    private String name;
    @NotBlank(message = "Name is required")
    private String image;
    @NotBlank(message = "Gaming is required")
    @Min(value = 0,message = "Gaming must be greater than or equal to 0")
    @Pattern(regexp = "^\\d+$",message = "Gaming must be a integer")
    private int gaming;
    @NotBlank(message = "Gaming is required")
    private String trailer;
    @NotNull(message = "gameType is required")
    private GameType gameType;

    public GameDto() {
    }

    public GameDto(Long gameId, String content, int flagDelete, String name,
                   String image, int gaming, String trailer, GameType gameType) {
        this.gameId = gameId;
        this.content = content;
        this.flagDelete = flagDelete;
        this.name = name;
        this.image = image;
        this.gaming = gaming;
        this.trailer = trailer;
        this.gameType = gameType;
    }

    public GameDto(String content, int flagDelete, String name,
                   String image, int gaming, String trailer, GameType gameType) {
        this.content = content;
        this.flagDelete = flagDelete;
        this.name = name;
        this.image = image;
        this.gaming = gaming;
        this.trailer = trailer;
        this.gameType = gameType;
    }

    public GameDto(Long gameId, String content,String name,
                   String image, int gaming, String trailer, GameType gameType) {
        this.gameId = gameId;
        this.content = content;
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

    public int getGaming() {
        return gaming;
    }

    public void setGaming(int gaming) {
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

    public void setGameType(GameType gameTypeId) {
        this.gameType= gameTypeId;
    }
}

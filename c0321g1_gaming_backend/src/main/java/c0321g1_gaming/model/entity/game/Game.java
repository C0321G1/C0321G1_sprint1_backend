package c0321g1_gaming.model.entity.game;

import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    @Column(length = 2007)
    private String content;
    private int flagDelete;
    private String name;
    @Column(length = 1000)
    private String image;
    private Long gaming;
    private String trailer;
    @ManyToOne
    @JoinColumn(name = "gameTypeId",referencedColumnName = "gameTypeId")
    private GameType gameType;

    public Game() {
    }

    public Game(String content, int flagDelete, String name, String image, Long gaming, String trailer, GameType gameType) {
        this.content = content;
        this.flagDelete = flagDelete;
        this.name = name;
        this.image = image;
        this.gaming = gaming;
        this.trailer = trailer;
        this.gameType = gameType;
    }

    public Game(Long gameId, String content, String name, String image, Long gaming, String trailer, GameType gameType) {
        this.gameId = gameId;
        this.content = content;
        this.name = name;
        this.image = image;
        this.gaming = gaming;
        this.trailer = trailer;
        this.gameType = gameType;
    }

    public Game(Long gameId, String content, int flagDelete, String name, String image, Long gaming, String trailer, GameType gameType) {
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

    public Long getGaming() {
        return gaming;
    }

    public void setGaming(Long gaming) {
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
package Model;

import java.io.Serializable;

public class Game implements Serializable {
    private int gameId;
    private String gameName;
    private String gameAuthor;
    private String gameImg;
    private String gameDescription;
    private double gamePrice;
    private int gameYear;

    public Game(){}

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public int getGameYear() {
        return gameYear;
    }

    public void setGameYear(int gameYear) {
        this.gameYear = gameYear;
    }

    public String getGameAuthor() {
        return gameAuthor;
    }

    public void setGameAuthor(String gameAuthor) {
        this.gameAuthor = gameAuthor;
    }

    public String getGameImg() {
        return gameImg;
    }

    public void setGameImg(String gameImg) {
        this.gameImg = gameImg;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameAuthor='" + gameAuthor + '\'' +
                ", gameImg='" + gameImg + '\'' +
                ", gameDescription='" + gameDescription + '\'' +
                ", gamePrice=" + gamePrice +
                ", gameYear=" + gameYear +
                '}';
    }
}

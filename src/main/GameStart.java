package main;

import main.Cards.Card;

import fileio.CardInput;
import fileio.StartGameInput;
import main.Cards.*;

import static main.CardTypeEnum.*;
import static main.CardTypeEnum.GENERAL_KOCIORAW;

public class GameStart {
    private int playerOneDeckIdx;
    private int playerTwoDeckIdx;
    private int shuffleSeed;
    private Card playerOneHero;
    private Card playerTwoHero;
    private int startingPlayer;

    public GameStart(StartGameInput gameStart) {
        this.playerOneDeckIdx = gameStart.getPlayerOneDeckIdx();
        this.playerTwoDeckIdx = gameStart.getPlayerTwoDeckIdx();
        this.shuffleSeed = gameStart.getShuffleSeed();
        this.playerOneHero = buildHero(gameStart.getPlayerOneHero());
        this.playerTwoHero = buildHero(gameStart.getPlayerTwoHero());
        this.startingPlayer = gameStart.getStartingPlayer();
    }

    public int getPlayerOneDeckIdx() {
        return playerOneDeckIdx;
    }

    public void setPlayerOneDeckIdx(int playerOneDeckIdx) {
        this.playerOneDeckIdx = playerOneDeckIdx;
    }

    public int getPlayerTwoDeckIdx() {
        return playerTwoDeckIdx;
    }

    public void setPlayerTwoDeckIdx(int playerTwoDeckIdx) {
        this.playerTwoDeckIdx = playerTwoDeckIdx;
    }

    public int getShuffleSeed() {
        return shuffleSeed;
    }

    public void setShuffleSeed(int shuffleSeed) {
        this.shuffleSeed = shuffleSeed;
    }

    public Card getPlayerOneHero() {
        return playerOneHero;
    }

    public void setPlayerOneHero(Card playerOneHero) {
        this.playerOneHero = playerOneHero;
    }

    public Card getPlayerTwoHero() {
        return playerTwoHero;
    }

    public void setPlayerTwoHero(Card playerTwoHero) {
        this.playerTwoHero = playerTwoHero;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public Hero buildHero(CardInput hero) {
        return switch (hero.getName()) {
            case LORD_ROYCE -> new Lord_Royce(hero);
            case EMPRESS_THORINA -> new Empress_Thorina(hero);
            case KING_MUDFACE -> new King_Mudface(hero);
            case GENERAL_KOCIORAW -> new General_Kocioraw(hero);
            default -> null;
        };
    }
}

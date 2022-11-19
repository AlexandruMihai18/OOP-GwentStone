package main;

import fileio.StartGameInput;
import main.Cards.Hero;
import static main.CardTypeEnum.*;

public final class GameStart {
    private int playerOneDeckIdx;
    private int playerTwoDeckIdx;
    private int shuffleSeed;
    private Hero playerOneHero;
    private Hero playerTwoHero;
    private int startingPlayer;

    public GameStart(final StartGameInput gameStart) {
        this.playerOneDeckIdx = gameStart.getPlayerOneDeckIdx();
        this.playerTwoDeckIdx = gameStart.getPlayerTwoDeckIdx();
        this.shuffleSeed = gameStart.getShuffleSeed();
        this.playerOneHero = DeckBuilder.buildHero(gameStart.getPlayerOneHero());
        this.playerTwoHero = DeckBuilder.buildHero(gameStart.getPlayerTwoHero());
        this.startingPlayer = gameStart.getStartingPlayer();
    }

    public int getPlayerOneDeckIdx() {
        return playerOneDeckIdx;
    }

    public int getPlayerTwoDeckIdx() {
        return playerTwoDeckIdx;
    }

    public int getShuffleSeed() {
        return shuffleSeed;
    }

    public Hero getPlayerOneHero() {
        return playerOneHero;
    }

    public Hero getPlayerTwoHero() {
        return playerTwoHero;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }
}

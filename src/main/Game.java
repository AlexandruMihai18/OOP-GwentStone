package main;

import fileio.ActionsInput;
import fileio.GameInput;
import main.Actions.*;
import main.Cards.Card;
import main.Cards.Hero;

import java.util.ArrayList;

public final class Game {
    private GameStart gameStart;
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private Hero playerOneHero;
    private Hero playerTwoHero;
    private Board board = new Board();
    private final ArrayList<Action> actions = new ArrayList<>();

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Game(final GameInput gameStart) {
        setGameStart(new GameStart(gameStart.getStartGame()));
        setActions(gameStart.getActions());
        setPlayerOneDeck();
        setPlayerTwoDeck();
        setPlayerOneHero();
        setPlayerTwoHero();
    }

    public GameStart getGameStart() {
        return gameStart;
    }

    public void setGameStart(final GameStart gameStart) {
        this.gameStart = gameStart;
    }

    public Board getBoard() {
        return board;
    }

    /**
     * Setting up the game's board by assigning each player a deck and a hero,
     * assigning the starting player, giving each player mana and a card and creating the lanes.
     */
    public void setBoard() {
        board.setLanes();
        board.setPlayerOneDeck(playerOneDeck, gameStart.getShuffleSeed());
        board.setPlayerTwoDeck(playerTwoDeck, gameStart.getShuffleSeed());
        board.setPlayerOneHero(playerOneHero);
        board.setPlayerTwoHero(playerTwoHero);
        board.setTurn(gameStart.getStartingPlayer());
        board.setPlayerOneMana(board.getManaGiven());
        board.setPlayerOneHand();
        board.setPlayerTwoMana(board.getManaGiven());
        board.setPlayerTwoHand();
    }

    /**
     * Formating the given actions using the ActionBuilder class
     * @param actions given action, in JSON format
     */
    public void setActions(final ArrayList<ActionsInput> actions) {
        for (ActionsInput action : actions) {
            this.actions.add(ActionBuilder.buildAction(action));
        }
    }

    public ArrayList<Card> getPlayerOneDeck() {
        return playerOneDeck;
    }

    /**
     * Deep copying a deck from the given decks coresponding to the given index
     */
    public void setPlayerOneDeck() {
        playerOneDeck = DeckBuilder.deckCopy(Server.getServer().getPlayerOne().getDecks().
                        get(gameStart.getPlayerOneDeckIdx()));
    }

    public ArrayList<Card> getPlayerTwoDeck() {
        return playerTwoDeck;
    }

    /**
     * Deep copying a deck from the given decks coresponding to the given index
     */
    public void setPlayerTwoDeck() {
        playerTwoDeck = DeckBuilder.deckCopy(Server.getServer().getPlayerTwo().getDecks().
                        get(gameStart.getPlayerTwoDeckIdx()));
    }

    public Hero getPlayerOneHero() {
        return playerOneHero;
    }

    /**
     * Initializing the player one hero's using the information provided in the game start
     */
    public void setPlayerOneHero() {
        playerOneHero = gameStart.getPlayerOneHero();
    }

    public Hero getPlayerTwoHero() {
        return playerTwoHero;
    }

    /**
     * Initializing the player two hero's using the information provided in the game start
     */
    public void setPlayerTwoHero() {
        playerTwoHero = gameStart.getPlayerTwoHero();
    }

    /**
     * Starting with setting up the board and continuing following the actions given
     * In addition, checking if the victory requirement is fulfilled.
     */
    public void play() {
        setBoard();
        int counter = 0;
        for (int i = 0; i < actions.size(); i++) {
            actions.get(i).action(board);
            actions.get(i).setOutput(board);
            counter++;
            if (board.getVictory() != 0) {
                Server.getServer().setGamesPlayed();
                if (board.getVictory() == 1) {
                    Server.getServer().setPlayerOneWins();
                } else {
                    Server.getServer().setPlayerTwoWins();
                }
                Action endGame = new GameEnded();
                actions.add(counter, endGame);
            }
        }
    }
}

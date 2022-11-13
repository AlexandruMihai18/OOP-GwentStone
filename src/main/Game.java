package main;

import fileio.ActionsInput;
import fileio.GameInput;
import main.Actions.Action;
import main.Actions.Get_Player_Deck;
import main.Actions.Get_Player_Hero;
import main.Actions.Get_Player_Turn;
import main.Cards.Card;
import main.Cards.Hero;

import java.util.ArrayList;

import static main.ActionTypeEnum.*;

public class Game {
    private GameStart gameStart;
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private Card playerOneHero;
    private Card playerTwoHero;
    private Board board = new Board();
    private final ArrayList<Action> actions = new ArrayList<>();

    public ArrayList<Action> getActions() {
        return actions;
    }

    public Game(GameInput gameStart) {
        setGameStart(new GameStart(gameStart.getStartGame()));
        setActions(gameStart.getActions());
        setPlayerOneDeck();
        setPlayerTwoDeck();
    }

    public GameStart getGameStart() {
        return gameStart;
    }

    public void setGameStart(GameStart gameStart) {
        this.gameStart = gameStart;
    }


    public Board getBoard () {
        return board;
    }

    public void setBoard (Board board){
        this.board = board;
    }

    public void setActions (ArrayList < ActionsInput > actions) {
        for (ActionsInput action : actions) {
            this.actions.add(buildAction(action));
        }
    }

    public Action buildAction (ActionsInput action){
        return switch (action.getCommand()) {
            case GET_PLAYER_DECK -> new Get_Player_Deck(action);
            case GET_PLAYER_HERO -> new Get_Player_Hero(action);
            case GET_PLAYER_TURN -> new Get_Player_Turn(action);
            default -> null;
        };
    }

    public ArrayList<Card> getPlayerOneDeck () {
        return playerOneDeck;
    }

    public ArrayList<Card> getPlayerTwoDeck () {
        return playerTwoDeck;
    }

    public void setPlayerOneDeck () {
        playerOneDeck = new ArrayList<>(Server.getServer().getPlayerOne().getDecks().get(gameStart.getPlayerOneDeckIdx()));
        System.out.println(playerOneDeck);
    }

    public void setPlayerTwoDeck () {
        playerTwoDeck = new ArrayList<>(Server.getServer().getPlayerTwo().getDecks().get(gameStart.getPlayerTwoDeckIdx()));
    }

    public void play () {
        board.setPlayerOneDeck(playerOneDeck, gameStart.getShuffleSeed());
        board.setPlayerTwoDeck(playerTwoDeck, gameStart.getShuffleSeed());
        board.setPlayerOneHero(new Hero(gameStart.getPlayerOneHero()));
        board.setPlayerTwoHero(new Hero(gameStart.getPlayerTwoHero()));
        for (Action action : actions) {
            action.action(board);
            action.setOutput(this);
        }
    }
}

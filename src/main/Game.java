package main;

import fileio.ActionsInput;
import fileio.GameInput;
import main.Actions.*;
import main.Cards.Card;
import main.Cards.Hero;

import java.util.ArrayList;

import static main.ActionTypeEnum.*;

public class Game {
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

    public Game(GameInput gameStart) {
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
            case GET_CARDS_IN_HAND -> new Get_Cards_In_Hand(action);
            case END_PLAYER_TURN -> new End_Player_Turn(action);
            case PLACE_CARD -> new Place_Card(action);
            case GET_PLAYER_MANA -> new Get_Player_Mana(action);
            case GET_CARDS_ON_TABLE -> new Get_Cards_On_Table(action);
            case GET_CARD_AT_POSITION -> new Get_Card_At_Position(action);
            case GET_ENVIRONMENT_CARDS_IN_HAND -> new Get_Environment_Cards_In_Hand(action);
            case USE_ENVIRONMENT_CARD -> new Use_Environment_Card(action);
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
    }

    public void setPlayerTwoDeck () {
        playerTwoDeck = new ArrayList<>(Server.getServer().getPlayerTwo().getDecks().get(gameStart.getPlayerTwoDeckIdx()));
    }

    public Hero getPlayerOneHero() {
        return playerOneHero;
    }

    public void setPlayerOneHero() {
        playerOneHero = new Hero(gameStart.getPlayerOneHero());
        playerOneHero.setHealth(30);
    }

    public Hero getPlayerTwoHero() {
        return playerTwoHero;
    }

    public void setPlayerTwoHero() {
        playerTwoHero = new Hero(gameStart.getPlayerOneHero());
        playerTwoHero.setHealth(30);
    }


    public void play () {
        board.setPlayerOneDeck(playerOneDeck, gameStart.getShuffleSeed());
        board.setPlayerTwoDeck(playerTwoDeck, gameStart.getShuffleSeed());
        board.setPlayerOneHero(new Hero(playerOneHero));
        board.setPlayerTwoHero(new Hero(playerTwoHero));
        board.setTurn(gameStart.getStartingPlayer());
        board.setPlayerOneMana(board.getManaGiven());
        board.setPlayerOneHand();
        board.setPlayerTwoMana(board.getManaGiven());
        board.setPlayerTwoHand();

        for (Action action : actions) {
            action.action(board);
            action.setOutput(this);
            action.cleanBoard(board);
        }
    }
}

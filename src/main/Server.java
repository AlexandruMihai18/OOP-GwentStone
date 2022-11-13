package main;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.Input;
import main.Actions.Action;

import java.util.ArrayList;

public class Server {
    private static Server server;

    private Input input;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Game> games;
    private ArrayList<Action> output;

    private Server() {}

    public void resetServer() {
        server = null;
    }

    public static Server getServer() {
        if (server == null)
            server = new Server();
        return server;
    }

    public void uploadData(Input inputData) {
        input = inputData;
    }

    public void startServer() {
        setPlayerOne();
        setPlayerTwo();
        startGames();
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerOne() {
        playerOne = new Player(input.getPlayerOneDecks());
    }

    public void setPlayerTwo() {
        playerTwo = new Player(input.getPlayerTwoDecks());
    }

    public void startGames() {
        for (int i = 0; i < input.getGames().size(); i++) {
            games.add(new Game(input.getGames().get(i)));
            games.get(i).play();
        }
    }

    public void makeArrayResult(ArrayNode output) {
        for (Game game : games) {
            for (int j = 0; j < game.getActions().size(); j++) {
                // output.add(games.get(i).getActions().get(j).makeArrayResult());
            }
        }
    }
}

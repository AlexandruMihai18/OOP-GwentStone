package main;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.Input;

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

    public void setPlayerOne() {
        playerOne.setNrCardsInDeck(input.getPlayerOneDecks().getNrCardsInDeck());
        playerOne.setNrDecks(input.getPlayerOneDecks().getNrDecks());
        // playerOne.setDecks(input.getPlayerOneDecks().getDecks());
    }

    public void setPlayerTwo() {
        playerTwo.setNrCardsInDeck(input.getPlayerTwoDecks().getNrCardsInDeck());
        playerTwo.setNrDecks(input.getPlayerTwoDecks().getNrDecks());
        // playerTwo.setDecks(input.getPlayerTwoDecks().getDecks());
    }

    public void startGames() {
        for (int i = 0; i < input.getGames().size(); i++) {
            // games.add(input.getGames().get(i));
        }
    }

    public void write(ArrayNode output) {
        // this.output = output;
    }
}

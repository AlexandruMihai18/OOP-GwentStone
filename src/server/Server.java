package server;

import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.Input;

import java.util.ArrayList;

public final class Server {
    private static Server server;
    private Input input;
    private Decks playerOneDecks;
    private Decks playerTwoDecks;
    private final ArrayList<Game> games = new ArrayList<>();
    private int gamesPlayed;
    private int playerOneWins;
    private int playerTwoWins;

    private Server() {

    }
    /**
     * Declaring the Server as a Singleton pattern class
     */
    public static Server getServer() {
        if (server == null) {
            server = new Server();
        }
        return server;
    }

    /**
     * Reseting server and it's statistics
     */
    public void resetServer() {
        gamesPlayed = 0;
        playerOneWins = 0;
        playerTwoWins = 0;
        server = null;
    }

    public Decks getPlayerOne() {
        return playerOneDecks;
    }

    /**
     * Deep copying player one decks
     */
    public void setPlayerOneDecks() {
        playerOneDecks = new Decks(input.getPlayerOneDecks());
    }

    public Decks getPlayerTwo() {
        return playerTwoDecks;
    }

    /**
     * Deep copying player two decks
     */
    public void setPlayerTwoDecks() {
        playerTwoDecks = new Decks(input.getPlayerTwoDecks());
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * Incrementing the games played when a game is finished
     */
    public void setGamesPlayed() {
        gamesPlayed++;
    }

    public int getPlayerOneWins() {
        return playerOneWins;
    }

    /**
     * Incrementing the games won by player one after a game is won
     */
    public void setPlayerOneWins() {
        playerOneWins++;
    }

    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

    /**
     * Incrementing the games won by player two after a game is won
     */
    public void setPlayerTwoWins() {
        playerTwoWins++;
    }

    /**
     * Internally uploading data inside the server
     * @param inputData - JSON formated data containing the game setup
     *                  and commands
     */
    public void uploadData(final Input inputData) {
        input = inputData;
    }

    /**
     * Initializing the server by setting up the decks and beginning the
     * game flows.
     */
    public void startServer() {
        setPlayerOneDecks();
        setPlayerTwoDecks();
        startGames();
    }

    /**
     * Constructing the output resulted from the commands
     * @param output JSON formated output, further displayed in the main
     */
    public void importOutput(final ArrayNode output) {
        for (Game game : games) {
            for (int j = 0; j < game.getActions().size(); j++) {
                if (!game.getActions().get(j).getOutput().isEmpty()) {
                    output.add(game.getActions().get(j).getOutput());
                }
            }
        }
    }

    /**
     * Internally uploading the game commands and starting the game flows.
     */
    public void startGames() {
        for (int i = 0; i < input.getGames().size(); i++) {
            games.add(new Game(input.getGames().get(i)));
            games.get(i).play();
        }
    }
}

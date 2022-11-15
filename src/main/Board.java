package main;

import main.Cards.Card;
import main.Cards.Hero;
import main.Cards.Minion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Board{
    private final ArrayList<Card> playerOneHand = new ArrayList<>();
    private final ArrayList<Card> playerTwoHand = new ArrayList<>();
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private Card playerOneHero;
    private Card playerTwoHero;
    private int playerOneMana = 0;
    private int playerTwoMana = 0;
    private int manaGiven = 1;
    private int turnCounter = 0;
    private int turn;
    private ArrayList<Minion> playerOneBackLane = new ArrayList<>();
    private ArrayList<Minion> playerOneFrontLane = new ArrayList<>();
    private ArrayList<Minion> playerTwoFrontLane = new ArrayList<>();
    private ArrayList<Minion> playerTwoBackLane = new ArrayList<>();

    private int victory = 0;

    public ArrayList<Card> getPlayerOneHand() {
        return playerOneHand;
    }

    public void setPlayerOneHand() {
        playerOneHand.add(playerOneDeck.remove(0));
    }

    public ArrayList<Card> getPlayerTwoHand() {
        return playerTwoHand;
    }

    public void setPlayerTwoHand() {
        playerTwoHand.add(playerTwoDeck.remove(0));
    }

    public ArrayList<Card> getPlayerOneDeck() {
        return playerOneDeck;
    }

    public void setPlayerOneDeck(ArrayList<Card> playerOneDeck, int seed) {
        this.playerOneDeck = new ArrayList<>(playerOneDeck);
        Collections.shuffle(this.playerOneDeck, new Random(seed));
    }

    public ArrayList<Card> getPlayerTwoDeck() {
        return playerTwoDeck;
    }

    public void setPlayerTwoDeck(ArrayList<Card> playerTwoDeck, int seed) {
        this.playerTwoDeck = new ArrayList<>(playerTwoDeck);
        Collections.shuffle(this.playerTwoDeck, new Random(seed));
    }

    public Card getPlayerOneHero() {
        return playerOneHero;
    }

    public void setPlayerOneHero(Card playerOneHero) {
        this.playerOneHero = new Hero(playerOneHero);
    }

    public Card getPlayerTwoHero() {
        return playerTwoHero;
    }

    public void setPlayerTwoHero(Card playerTwoHero) {
        this.playerTwoHero = new Hero(playerTwoHero);
    }

    public int getManaGiven() {
        return manaGiven;
    }

    public void setManaGiven() {
        if (manaGiven < 10)
            manaGiven++;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getPlayerOneMana() {
        return playerOneMana;
    }

    public void setPlayerOneMana(int playerOneMana) {
        this.playerOneMana += playerOneMana;
    }

    public int getPlayerTwoMana() {
        return playerTwoMana;
    }

    public void setPlayerTwoMana(int playerTwoMana) {
        this.playerTwoMana += playerTwoMana;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter() {
        turnCounter++;
    }

    public ArrayList<Minion> getPlayerOneBackLane() {
        return playerOneBackLane;
    }

    public ArrayList<Minion> getPlayerOneFrontLane() {
        return playerOneFrontLane;
    }

    public ArrayList<Minion> getPlayerTwoFrontLane() {
        return playerTwoFrontLane;
    }

    public ArrayList<Minion> getPlayerTwoBackLane() {
        return playerTwoBackLane;
    }

    public int getVictory() {
        return victory;
    }

    public void clearBoard() {
        playerOneBackLane.removeIf(minion -> (minion.getHealth() <= 0));
        playerOneFrontLane.removeIf(minion -> (minion.getHealth() <= 0));
        playerTwoFrontLane.removeIf(minion -> (minion.getHealth() <= 0));
        playerTwoBackLane.removeIf(minion -> (minion.getHealth() <= 0));
    }

    public void checkVictory() {
        if (playerOneHero.getHealth() <= 0)
            victory = 2;
        if (playerTwoHero.getHealth() <= 0)
            victory = 1;
    }
}

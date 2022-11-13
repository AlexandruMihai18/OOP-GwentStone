package main;

import main.Cards.Card;
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
    private int playerOneMana;
    private int playerTwoMana;
    private static int manaGiven = 1;
    private int turn;
    private Card[][] lanes = new Card[4][5];

    public void setBoard() {

    }
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
        playerOneHand.add(playerOneDeck.remove(0));
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
        this.playerOneHero = playerOneHero;
    }

    public Card getPlayerTwoHero() {
        return playerTwoHero;
    }

    public void setPlayerTwoHero(Card playerTwoHero) {
        this.playerTwoHero = playerTwoHero;
    }

    public static int getManaGiven() {
        return manaGiven;
    }

    public static void setManaGiven(int manaGiven) {
        Board.manaGiven = manaGiven;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Card[][] getLanes() {
        return lanes;
    }

    public void setLanes(Card[][] lanes) {
        this.lanes = lanes;
    }
}

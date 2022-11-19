package main.Server;

import main.Cards.Card;
import main.Cards.Hero;
import main.Cards.Minion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static main.Helpers.MagicNumbers.*;


public final class Board {
    private final ArrayList<Card> playerOneHand = new ArrayList<>();
    private final ArrayList<Card> playerTwoHand = new ArrayList<>();
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private Hero playerOneHero;
    private Hero playerTwoHero;
    private int manaGiven = 1;
    private int playerOneMana = 0;
    private int playerTwoMana = 0;
    private int turn;
    private int turnCounter = 0;
    private final ArrayList<ArrayList<Minion>> lanes = new ArrayList<>();
     private int victory = 0;

    public ArrayList<Card> getPlayerOneHand() {
        return playerOneHand;
    }

    /**
     * Removing the top card of the deck and moving it in the player one's hand
     */
    public void setPlayerOneHand() {
        if (!playerOneDeck.isEmpty()) {
            playerOneHand.add(playerOneDeck.remove(0));
        }
    }

    public ArrayList<Card> getPlayerTwoHand() {
        return playerTwoHand;
    }

    /**
     * Removing the top card of the deck and moving it in the player two's hand
     */
    public void setPlayerTwoHand() {
        if (!playerTwoDeck.isEmpty()) {
            playerTwoHand.add(playerTwoDeck.remove(0));
        }
    }

    public ArrayList<Card> getPlayerOneDeck() {
        return playerOneDeck;
    }

    /**
     * Shallow copying the deck and shuffling it
     * @param playerOneDeck provided deck
     * @param shuffleSeed seed required for the shuffle deck action
     */
    public void setPlayerOneDeck(final ArrayList<Card> playerOneDeck, final int shuffleSeed) {
        this.playerOneDeck = playerOneDeck;
        Collections.shuffle(this.playerOneDeck, new Random(shuffleSeed));
    }

    public ArrayList<Card> getPlayerTwoDeck() {
        return playerTwoDeck;
    }

    /**
     * Shallow copying the deck and shuffling it
     * @param playerTwoDeck provided deck
     * @param shuffleSeed seed required for the shuffle deck action
     */
    public void setPlayerTwoDeck(final ArrayList<Card> playerTwoDeck, final int shuffleSeed) {
        this.playerTwoDeck = playerTwoDeck;
        Collections.shuffle(this.playerTwoDeck, new Random(shuffleSeed));
    }

    public Hero getPlayerOneHero() {
        return playerOneHero;
    }

    public void setPlayerOneHero(final Hero playerOneHero) {
        this.playerOneHero = playerOneHero;
    }

    public Hero getPlayerTwoHero() {
        return playerTwoHero;
    }

    public void setPlayerTwoHero(final Hero playerTwoHero) {
        this.playerTwoHero = playerTwoHero;
    }

    public int getManaGiven() {
        return manaGiven;
    }

    /**
     * Progressively incrementing the mana given at the start of the round as the game progresses
     */
    public void setManaGiven() {
        if (manaGiven < MAX_MANA_GIVEN) {
            manaGiven++;
        }
    }

    public int getPlayerOneMana() {
        return playerOneMana;
    }

    /**
     * Adding mana to player one mana pool
     * @param playerOneMana mana that needs to be added
     */
    public void setPlayerOneMana(final int playerOneMana) {
        this.playerOneMana += playerOneMana;
    }

    public int getPlayerTwoMana() {
        return playerTwoMana;
    }

    /**
     * Adding mana to a player two mana pool
     * @param playerTwoMana mana that needs to be added
     */
    public void setPlayerTwoMana(final int playerTwoMana) {
        this.playerTwoMana += playerTwoMana;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(final int turn) {
        this.turn = turn;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    /**
     * Incrementing the round counter as the game progresses
     */
    public void setTurnCounter() {
        turnCounter++;
    }

    public ArrayList<ArrayList<Minion>> getLanes() {
        return lanes;
    }

    /**
     * Setting up the lanes of the board as empty array lists
     */
    public void setLanes() {
        for (int i = 0; i < NUMBER_LANES; i++) {
            ArrayList<Minion> newLane = new ArrayList<>();
            lanes.add(newLane);
        }
    }
    public int getVictory() {
        return victory;
    }
    public void setVictory(final int victory) {
        this.victory = victory;
    }

    /**
     * Clearing the minions that have died (have negative health)
     */
    public void clearMinions() {
        for (ArrayList<Minion> lane : lanes) {
            lane.removeIf(minion -> minion.getHealth() <= 0);
        }
    }

    /**
     * Reseting player's minions by marking them as not frozen and not used for that round
     */
    public void resetMinions() {
        switch (turn) {
            case 1 -> {
                for (int i = MIDDLE_LANE; i < NUMBER_LANES; i++) {
                    for (Minion minion : lanes.get(i)) {
                        minion.setFrozen(false);
                        minion.setUsed(false);
                    }
                }
                playerOneHero.setUsed(false);
            }
            case 2 -> {
                for (int i = 0; i < MIDDLE_LANE; i++) {
                    for (Minion minion : lanes.get(i)) {
                        minion.setFrozen(false);
                        minion.setUsed(false);
                    }
                }
                playerTwoHero.setUsed(false);
            }
            default -> {

            }
        }
    }

    /**
     * Getting player's hero according to the turn field
     * @return player's hero
     */
    public Hero getMyHero() {
        if (turn == 1) {
            return playerOneHero;
        } else {
            return playerTwoHero;
        }
    }

    /**
     * Getting enemy player's hero according to the turn field
     * @return enemy player's hero
     */
    public Hero getEnemyHero() {
        if (turn == 1) {
            return playerTwoHero;
        } else {
            return playerOneHero;
        }
    }

    /**
     * Check if the victory condition is fulfilled, one player's hero dies.
     */
    public void checkVictory() {
        if (playerOneHero.getHealth() <= 0) {
            victory = 2;
        }
        if (playerTwoHero.getHealth() <= 0) {
            victory = 1;
        }
    }
}

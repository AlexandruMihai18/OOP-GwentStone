package main.Helpers;

import fileio.Coordinates;
import main.Server.Board;
import main.Cards.Card;
import main.Cards.Hero;
import main.Cards.Minion;

import java.util.ArrayList;

import static main.Helpers.CardTypeEnum.*;
import static main.Helpers.MagicNumbers.*;

public final class ErrorHandler {
    public static final String NO_CARD = "No card at that position.";
    public static final String IS_FROZEN = "Attacker card is frozen.";
    public static final String IS_USED = "Attacker card has already attacked this turn.";
    public static final String NOT_ALLY = "Attacked card does not belong to the current player.";
    public static final String NOT_ENEMY = "Attacked card does not belong to the enemy.";
    public static final String NOT_TANK = "Attacked card is not of type 'Tank'.";
    public static final String NOT_ENOUGH_MANA = "Not enough mana to place card on table.";
    public static final String NOT_MINION = "Cannot place environment card on table.";
    public static final String NOT_ENVIRONMENT = "Chosen card is not of type environment.";
    public static final String IS_FULL = "Cannot place card on table since row is full.";
    public static final String NOT_ENEMY_ROW = "Chosen row does not belong to the enemy.";
    public static final String HERO_NOT_ENEMY_ROW = "Selected row does not belong to the enemy.";
    public static final String HERO_NOT_ALLY_ROW
            = "Selected row does not belong to the current player.";
    public static final String CANNOT_STEAL
            = "Cannot steal enemy card since the player's row is full.";
    public static final String HERO_IS_USED = "Hero has already attacked this turn.";
    public static final String HERO_NOT_ENOUGH_MANA = "Not enough mana to use hero's ability.";
    public static final String ENVIRONMENT_NOT_ENOUGH_MANA
            = "Not enough mana to use environment card.";

    private ErrorHandler() {

    }

    /**
     * Checking if there is a card on the specified position
     * @param board given board
     * @param x lane
     * @param y position in the lane
     * @return true - there is a card, false - otherwise
     */
    public static boolean isCard(final Board board, final int x, final int y) {
        ArrayList<Minion> lane = board.getLanes().get(x);
        if (lane.size() <= y) {
            return false;
        }
        return true;
    }

    /**
     * Checking if a minion is frozen
     * @param minion checked minion
     * @return true - minion is frozen, false - otherwise
     */
    public static boolean isFrozen(final Minion minion) {
        return minion.isFrozen();
    }

    /**
     * Checking if the minion has already been used in a round
     * @param minion checked minion
     * @return true - minion has been used this round, false - otherwise
     */
    public static boolean isUsed(final Minion minion) {
        return minion.isUsed();
    }

    /**
     * Checking if the given coordinates corespond to an enemy card
     * @param board given board
     * @param coordinates minion coordinates
     * @return true - the card coresponds to the enemy, false - otherwise
     */
    public static boolean isEnemyCard(final Board board, final Coordinates coordinates) {
        switch (board.getTurn()) {
            case 1:
                return (coordinates.getX() < MIDDLE_LANE);
            case 2:
                return (coordinates.getX() >= MIDDLE_LANE);
            default:
                return true;
        }
    }

    /**
     * Checking if a minion is Disciple type
     * @param minion given minion
     * @return true - minion is Disciple type, false - otherwise
     */
    public static boolean isDisciple(final Minion minion) {
        return minion.getName().equals(DISCIPLE);
    }

    /**
     * Checking if there is a tank between enemy's placed cards.
     * @param board given board
     * @return true - the board contains an enemy tank, false - otherwise
     */
    public static boolean isThereTank(final Board board) {
        switch (board.getTurn()) {
            case 1:
                for (Minion minion : board.getLanes().get(PLAYER_TWO_FRONT_LANE)) {
                    if (minion.isTank()) {
                        return true;
                    }
                }
                break;
            case 2:
                for (Minion minion : board.getLanes().get(PLAYER_ONE_FRONT_LANE)) {
                    if (minion.isTank()) {
                        return true;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }

    /**
     * Checking if the player has enough mana to play a card
     * @param board given board
     * @param card checked card
     * @return true - player has enough mana to use card, false - otherwise
     */
    public static boolean enoughMana(final Board board, final Card card) {
        switch (board.getTurn()) {
            case 1: return card.getMana() <= board.getPlayerOneMana();
            case 2: return card.getMana() <= board.getPlayerTwoMana();
            default: return true;
        }
    }

    /**
     * Checking if a card is Minion type
     * @param card checked card
     * @return true - card is Minion type, false - otherwise
     */
    public static boolean isMinion(final Card card) {
        return card.getType().equals("Minion");
    }

    /**
     * Checking if the table is full to place a minion
     * @param board given board
     * @param minion minion to add
     * @return true - the board is full, false - otherwise
     */
    public static boolean isTableFull(final Board board, final Minion minion) {
        switch (board.getTurn()) {
            case 1 -> {
                return (board.getLanes()
                        .get(NUMBER_LANES - 1 - minion.getRequiredRow()).size() == MAX_MINIONS);
            }
            case 2 -> {
                return (board.getLanes().get(minion.getRequiredRow()).size() == MAX_MINIONS);
            }
            default -> {
                return true;
            }
        }
    }

    /**
     * Checking if a card is Environment type
     * @param card checked card
     * @return true - card is Environment type, false - otherwise
     */
    public static boolean isEnvironment(final Card card) {
        return card.getType().equals("Environment");
    }

    /**
     * Checking if a row belongs to the enemy
     * @param board given board
     * @param row checked row
     * @return true - row belongs to enemy, false - otherwise
     */
    public static boolean isEnemyRow(final Board board, final int row) {
        switch (board.getTurn()) {
            case 1 -> {
                return (row == PLAYER_TWO_BACK_LANE || row == PLAYER_TWO_FRONT_LANE);
            }
            case 2 -> {
                return (row == PLAYER_ONE_FRONT_LANE || row == PLAYER_ONE_BACK_LANE);
            }
            default -> {
                return true;
            }
        }
    }

    /**
     * Checking if a card is Heart Hound type
     * @param card checked card
     * @return true - card is Heart Hound type, false - otherwise
     */
    public static boolean isHeartHound(final Card card) {
        return card.getName().equals(HEART_HOUND);
    }

    /**
     * Checking if a player is able to steal from a row using Heart Hound
     * @param board given board
     * @param row row to steal from
     * @return true - player can steal from the row, false - otherwise
     */
    public static boolean ableToSteal(final Board board, final int row) {
        return !(board.getLanes().get(NUMBER_LANES - 1 - row).size() == MAX_MINIONS);
    }

    /**
     * Checking if a hero has already been used this round
     * @param hero provided hero
     * @return true - hero has been used, false - otherwise
     */
    public static boolean isUsed(final Hero hero) {
        return hero.isUsed();
    }

    /**
     * Checking if the hero's ability affects enemy's rows
     * @param hero hero to perform the action
     * @return true - hero's ability affects enemy's rows, false - otherwise
     */
    public static boolean affectsEnemy(final Hero hero) {
        return (hero.getName().equals(LORD_ROYCE) || hero.getName().equals(EMPRESS_THORINA));
    }
}

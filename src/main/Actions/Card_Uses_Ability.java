package main.Actions;

import fileio.ActionsInput;
import fileio.Coordinates;
import main.Board;
import main.Cards.Minion;
import main.Game;

import java.util.ArrayList;

import static main.CardTypeEnum.DISCIPLE;

public class Card_Uses_Ability extends Action{
    public Card_Uses_Ability(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {

    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("cardAttacker", formatCoordinates(getCardAttacker()));
        getOutput().put("cardAttacked", formatCoordinates(getCardAttacked()));
        getOutput().put("error", error);
    }

    @Override
    public void action(Board board) {
        Minion minionAttacker = getCardOnBoard(board, getCardAttacker());
        Minion minionAttacked = getCardOnBoard(board, getCardAttacked());

        if (minionAttacker.isFrozen()) {
            setError("Attacker card is frozen.");
            return;
        }

        if (minionAttacker.isUsed()) {
            setError("Attacker card has already attacked this turn");
            return;
        }

        if (minionAttacker.getName().equals(DISCIPLE)) {
            if (isEnemyCard(board, getCardAttacked())) {
                setError("Attacked card does not belong to the current player.");
                return;
            }
        } else {
            if (!isEnemyCard(board, getCardAttacked())) {
                setError("Attacked card does not belong to the enemy.");
                return;
            }
        }

        if (!minionAttacker.getName().equals(DISCIPLE) && checkForTank(board) && !minionAttacked.isTaunt()) {
            setError("Attacked card is not of type 'Tank'.");
            return;
        }

        minionAttacked.ability(getLane(board, getCardAttacked().getX()), getCardAttacked().getY());
        minionAttacker.setUsed(true);
    }

    public ArrayList<Minion> getLane(Board board, int x) {
        switch (x) {
            case 0:
                return board.getPlayerTwoBackLane();
            case 1:
                return board.getPlayerTwoFrontLane();
            case 2:
                return board.getPlayerOneFrontLane();
            case 3:
                return board.getPlayerOneBackLane();
            default:
                return null;
        }
    }

    public Minion getCardOnBoard(Board board, Coordinates coordinates) {
        switch (coordinates.getX()) {
            case 0:
                return board.getPlayerTwoBackLane().get(coordinates.getY());
            case 1:
                return board.getPlayerTwoFrontLane().get(coordinates.getY());
            case 2:
                return board.getPlayerOneFrontLane().get(coordinates.getY());
            case 3:
                return board.getPlayerOneBackLane().get(coordinates.getY());
            default: return null;
        }
    }

    public boolean isEnemyCard(Board board, Coordinates coordinates) {
        switch (board.getTurn()) {
            case 1:
                if (coordinates.getX() >= 2)
                    return false;
                break;
            case 2:
                if (coordinates.getX() < 2)
                    return false;
                break;
        }
        return true;
    }

    public boolean checkForTank(Board board) {
        switch (board.getTurn()) {
            case 1:
                for (Minion minion : board.getPlayerTwoFrontLane()) {
                    if (minion.isTaunt())
                        return true;
                }
                break;
            case 2:
                for (Minion minion : board.getPlayerOneFrontLane()) {
                    if (minion.isTaunt())
                        return true;
                }
        }
        return false;
    }
}

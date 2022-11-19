package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;
import main.Cards.Minion;
import main.Helpers.ErrorHandler;
import main.Helpers.FormatOutput;

import static main.Helpers.ErrorHandler.IS_FROZEN;
import static main.Helpers.ErrorHandler.IS_USED;
import static main.Helpers.ErrorHandler.NOT_ALLY;
import static main.Helpers.ErrorHandler.NOT_ENEMY;
import static main.Helpers.ErrorHandler.NOT_TANK;

public final class CardUsesAbility extends Action {
    public CardUsesAbility(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("cardAttacker", FormatOutput.formatCoordinates(getCardAttacker()));
        getOutput().put("cardAttacked", FormatOutput.formatCoordinates(getCardAttacked()));
        getOutput().put("error", error);
    }

    @Override
    public void action(final Board board) {
        Minion minionAttacker = board.getLanes().get(getCardAttacker().getX())
                                .get(getCardAttacker().getY());
        Minion minionAttacked = board.getLanes().get(getCardAttacked().getX())
                                .get(getCardAttacked().getY());

        if (ErrorHandler.isFrozen(minionAttacker)) {
            setError(IS_FROZEN);
            return;
        }

        if (ErrorHandler.isUsed(minionAttacker)) {
            setError(IS_USED);
            return;
        }

        if (ErrorHandler.isDisciple(minionAttacker)) {
            if (ErrorHandler.isEnemyCard(board, getCardAttacked())) {
                setError(NOT_ALLY);
                return;
            }
        } else {
            if (!ErrorHandler.isEnemyCard(board, getCardAttacked())) {
                setError(NOT_ENEMY);
                return;
            }
        }

        if (!ErrorHandler.isDisciple(minionAttacker) && ErrorHandler.isThereTank(board)
                && !minionAttacked.isTank()) {
            setError(NOT_TANK);
            return;
        }

        minionAttacker.ability(minionAttacked);
        minionAttacker.setUsed(true);
        board.clearMinions();
    }
}

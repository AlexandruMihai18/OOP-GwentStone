package actions;

import fileio.ActionsInput;
import cards.Minion;
import helpers.ErrorHandler;
import helpers.FormatOutput;
import server.Board;

import static helpers.ErrorHandler.*;


public final class CardUsesAttack extends Action {
    public CardUsesAttack(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("cardAttacker", FormatOutput.formatCoordinates(getCardAttacker()));
        getOutput().putPOJO("cardAttacked", FormatOutput.formatCoordinates(getCardAttacked()));
        getOutput().putPOJO("error", error);
    }

    @Override
    public void action(final Board board) {
        Minion minionAttacker = board.getLanes().get(getCardAttacker().getX())
                                .get(getCardAttacker().getY());
        Minion minionAttacked = board.getLanes().get(getCardAttacked().getX())
                                .get(getCardAttacked().getY());

        if (!ErrorHandler.isEnemyCard(board, getCardAttacked())) {
            setError("Attacked card does not belong to the enemy.");
            return;
        }

        if (ErrorHandler.isFrozen(minionAttacker)) {
            setError(IS_FROZEN);
            return;
        }

        if (ErrorHandler.isUsed(minionAttacker)) {
            setError(IS_USED);
            return;
        }

        if (ErrorHandler.isThereTank(board) && !minionAttacked.isTank()) {
            setError(NOT_TANK);
            return;
        }

        minionAttacked.setHealth(-minionAttacker.getAttackDamage());
        minionAttacker.setUsed(true);
        board.clearMinions();
    }
}
package main.Actions;

import fileio.ActionsInput;
import main.Cards.Minion;
import main.Helpers.ErrorHandler;
import main.Helpers.FormatOutput;
import main.Server.Board;

import static main.Helpers.ErrorHandler.*;


public final class CardUsesAttack extends Action {
    public CardUsesAttack(final ActionsInput action) {
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

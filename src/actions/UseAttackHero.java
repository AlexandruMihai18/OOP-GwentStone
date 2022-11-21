package actions;

import fileio.ActionsInput;
import cards.Hero;
import cards.Minion;
import helpers.ErrorHandler;
import helpers.FormatOutput;
import server.Board;

import static helpers.ErrorHandler.*;

public final class UseAttackHero extends Action {
    public UseAttackHero(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
    }

    @Override
    public void setError(final String error) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("cardAttacker", FormatOutput.formatCoordinates(getCardAttacker()));
        getOutput().putPOJO("error", error);
    }

    @Override
    public void action(final Board board) {
        Minion minionAttacker = board.getLanes().get(getCardAttacker().getX())
                                .get(getCardAttacker().getY());
        Hero hero = board.getEnemyHero();

        if (ErrorHandler.isFrozen(minionAttacker)) {
            setError(IS_FROZEN);
            return;
        }

        if (ErrorHandler.isUsed(minionAttacker)) {
            setError(IS_USED);
            return;
        }

        if (ErrorHandler.isThereTank(board)) {
            setError(NOT_TANK);
            return;
        }

        hero.setHealth(-minionAttacker.getAttackDamage());
        minionAttacker.setUsed(true);
        if (hero.getHealth() <= 0) {
            board.setVictory(board.getTurn());
        }
    }
}

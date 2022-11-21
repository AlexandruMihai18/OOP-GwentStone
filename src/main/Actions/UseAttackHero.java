package main.Actions;

import fileio.ActionsInput;
import main.Cards.Hero;
import main.Cards.Minion;
import main.Helpers.ErrorHandler;
import main.Helpers.FormatOutput;
import main.Server.Board;

import static main.Helpers.ErrorHandler.*;

public final class UseAttackHero extends Action {
    public UseAttackHero(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
    }

    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("cardAttacker", FormatOutput.formatCoordinates(getCardAttacker()));
        getOutput().put("error", error);
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

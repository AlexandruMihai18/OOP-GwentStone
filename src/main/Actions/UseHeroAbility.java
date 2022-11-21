package main.Actions;

import fileio.ActionsInput;
import main.Cards.Hero;
import main.Helpers.ErrorHandler;
import main.Server.Board;

import static main.Helpers.ErrorHandler.*;

public final class UseHeroAbility extends Action {
    public UseHeroAbility(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("affectedRow", getAffectedRow());
        getOutput().put("error", error);
    }

    @Override
    public void action(final Board board) {
        Hero hero = board.getMyHero();

        if (!ErrorHandler.enoughMana(board, hero)) {
            setError(HERO_NOT_ENOUGH_MANA);
            return;
        }

        if (ErrorHandler.isUsed(hero)) {
            setError(HERO_IS_USED);
            return;
        }

        if (ErrorHandler.affectsEnemy(hero)) {
            if (!ErrorHandler.isEnemyRow(board, getAffectedRow())) {
                setError(HERO_NOT_ENEMY_ROW);
                return;
            }
        } else {
            if (ErrorHandler.isEnemyRow(board, getAffectedRow())) {
                setError(HERO_NOT_ALLY_ROW);
                return;
            }
        }

        if (board.getTurn() == 1) {
            board.setPlayerOneMana(-hero.getMana());
        } else {
            board.setPlayerTwoMana(-hero.getMana());
        }

        hero.ability(board.getLanes().get(getAffectedRow()));
        hero.setUsed(true);
        board.clearMinions();
    }
}

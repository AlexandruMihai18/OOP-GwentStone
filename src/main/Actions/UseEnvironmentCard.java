package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;
import main.Cards.Card;
import main.Cards.HeartHound;
import main.Helpers.ErrorHandler;

import static main.Helpers.ErrorHandler.NOT_ENVIRONMENT;
import static main.Helpers.ErrorHandler.ENVIRONMENT_NOT_ENOUGH_MANA;
import static main.Helpers.ErrorHandler.CANNOT_STEAL;
import static main.Helpers.ErrorHandler.NOT_ENEMY_ROW;

public final class UseEnvironmentCard extends Action {

    public UseEnvironmentCard(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("handIdx", getPlayerIdx());
        getOutput().put("affectedRow", getAffectedRow());
        getOutput().put("error", error);
    }

    @Override
    public void action(final Board board) {
        Card card;

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().get(getHandIdx());
        } else {
            card = board.getPlayerTwoHand().get(getHandIdx());
        }

        if (!ErrorHandler.isEnvironment(card)) {
            setError(NOT_ENVIRONMENT);
            return;
        }

        if (!ErrorHandler.enoughMana(board, card)) {
            setError(ENVIRONMENT_NOT_ENOUGH_MANA);
            return;
        }

        if (!ErrorHandler.isEnemyRow(board, getAffectedRow())) {
            setError(NOT_ENEMY_ROW);
            return;
        }

        if (ErrorHandler.isHeartHound(card)
                && !ErrorHandler.ableToSteal(board, getAffectedRow())) {
            setError(CANNOT_STEAL);
            return;
        }

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().remove(getHandIdx());
            board.setPlayerOneMana(-card.getMana());
        } else {
            card = board.getPlayerTwoHand().remove(getHandIdx());
            board.setPlayerTwoMana(-card.getMana());
        }

        if (ErrorHandler.isHeartHound(card)) {
            ((HeartHound) card).ability(board, getAffectedRow());
        } else {
            card.ability(board.getLanes().get(getAffectedRow()));
        }

        board.clearMinions();
    }
}

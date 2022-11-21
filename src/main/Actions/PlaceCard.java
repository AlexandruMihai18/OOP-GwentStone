package main.Actions;

import fileio.ActionsInput;
import main.Cards.Card;
import main.Cards.Minion;
import main.Helpers.ErrorHandler;
import main.Server.Board;

import static main.Helpers.ErrorHandler.*;
import static main.Helpers.MagicNumbers.NUMBER_LANES;

public final class PlaceCard extends Action {
    public PlaceCard(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("handIdx", getPlayerIdx());
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

        if (!ErrorHandler.enoughMana(board, card)) {
            setError(NOT_ENOUGH_MANA);
            return;
        }

        if (!ErrorHandler.isMinion(card)) {
            setError(NOT_MINION);
            return;
        }

        if (ErrorHandler.isTableFull(board, (Minion) card)) {
          setError(IS_FULL);
          return;
        }

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().remove(getHandIdx());
            board.getLanes().get(NUMBER_LANES - 1 - ((Minion) card).getRequiredRow())
                    .add((Minion) card);
            board.setPlayerOneMana(-card.getMana());
        } else {
            card = board.getPlayerTwoHand().remove(getHandIdx());
            board.getLanes().get(((Minion) card).getRequiredRow()).add((Minion) card);
            board.setPlayerTwoMana(-card.getMana());
        }
    }
}

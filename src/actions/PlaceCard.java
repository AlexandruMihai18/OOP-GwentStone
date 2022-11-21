package actions;

import fileio.ActionsInput;
import cards.Card;
import cards.Minion;
import helpers.ErrorHandler;
import server.Board;

import static helpers.ErrorHandler.*;
import static helpers.MagicNumbers.NUMBER_LANES;

public final class PlaceCard extends Action {
    public PlaceCard(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("handIdx", getPlayerIdx());
        getOutput().putPOJO("error", error);
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

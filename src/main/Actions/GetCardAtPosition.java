package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;
import main.Cards.Minion;
import main.Helpers.ErrorHandler;
import main.Helpers.FormatOutput;

import static main.Helpers.ErrorHandler.NO_CARD;

public class GetCardAtPosition extends Action {
    public GetCardAtPosition(final ActionsInput action) {
        super(action);
    }

    /**
     * Setting action output by displaying the card at a certain position
     * @param board given board
     */
    @Override
    public void setOutput(final Board board) {
        if (!ErrorHandler.isCard(board, getX(), getY())) {
            setError(NO_CARD);
            return;
        }

        Minion minion = board.getLanes().get(getX()).get(getY());

        getOutput().put("command", getCommand());
        getOutput().put("output", FormatOutput.formatMinion(new Minion(minion)));
    }

    /**
     * Error case for no such card at the specified position
     * @param error error message
     */
    @Override
    public void setError(final String error) {
        getOutput().put("command", getCommand());
        getOutput().put("error", error);
    }

    @Override
    public void action(final Board board) {

    }
}

package actions;

import fileio.ActionsInput;
import cards.Minion;
import helpers.ErrorHandler;
import helpers.FormatOutput;
import server.Board;

import static helpers.ErrorHandler.NO_CARD;

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

        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("x", getX());
        getOutput().putPOJO("y", getY());
        getOutput().putPOJO("output", FormatOutput.formatMinion(new Minion(minion)));
    }

    /**
     * Error case for no such card at the specified position
     * @param error error message
     */
    @Override
    public void setError(final String error) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("x", getX());
        getOutput().putPOJO("y", getY());
        getOutput().putPOJO("output", error);
    }

    @Override
    public void action(final Board board) {

    }
}

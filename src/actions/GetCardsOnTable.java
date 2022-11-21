package actions;

import fileio.ActionsInput;
import helpers.FormatOutput;
import server.Board;

public final class GetCardsOnTable extends Action {
    public GetCardsOnTable(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("output", FormatOutput.formatTable(board.getLanes()));
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

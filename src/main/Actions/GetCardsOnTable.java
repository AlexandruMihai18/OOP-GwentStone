package main.Actions;

import fileio.ActionsInput;
import main.Helpers.FormatOutput;
import main.Server.Board;

public final class GetCardsOnTable extends Action {
    public GetCardsOnTable(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("output", FormatOutput.formatTable(board.getLanes()));
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

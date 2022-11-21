package main.Actions;

import fileio.ActionsInput;
import main.Helpers.FormatOutput;
import main.Server.Board;

public final class GetFrozenCardsOnTable extends Action {
    public GetFrozenCardsOnTable(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("output", FormatOutput.formatFrozenCards(board.getLanes()));
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

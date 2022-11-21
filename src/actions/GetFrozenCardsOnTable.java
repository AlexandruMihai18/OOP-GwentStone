package actions;

import fileio.ActionsInput;
import helpers.FormatOutput;
import server.Board;

public final class GetFrozenCardsOnTable extends Action {
    public GetFrozenCardsOnTable(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("output", FormatOutput.formatFrozenCards(board.getLanes()));
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

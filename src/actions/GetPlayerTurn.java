package actions;

import fileio.ActionsInput;
import server.Board;

public final class GetPlayerTurn extends Action {
    public GetPlayerTurn(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
         getOutput().putPOJO("command", getCommand());
         getOutput().putPOJO("output", board.getTurn());
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;

public final class GetPlayerTurn extends Action {
    public GetPlayerTurn(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
         getOutput().put("command", getCommand());
         getOutput().put("output", board.getTurn());
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

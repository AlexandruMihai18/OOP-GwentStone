package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;
import main.Server.Server;

public final class GetPlayerTwoWins extends Action {
    public GetPlayerTwoWins(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("output", Server.getServer().getPlayerTwoWins());
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

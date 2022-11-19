package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Server;

public final class GetPlayerOneWins extends Action {
    public GetPlayerOneWins(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("output", Server.getServer().getPlayerOneWins());
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

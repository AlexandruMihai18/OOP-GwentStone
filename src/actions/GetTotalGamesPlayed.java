package actions;

import fileio.ActionsInput;
import server.Board;
import server.Server;

public final class GetTotalGamesPlayed extends Action {
    public GetTotalGamesPlayed(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("output", Server.getServer().getGamesPlayed());
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

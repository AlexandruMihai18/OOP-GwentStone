package actions;

import fileio.ActionsInput;
import server.Board;

public final class GetPlayerMana extends Action {
    public GetPlayerMana(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> getOutput().putPOJO("output", board.getPlayerOneMana());
            case 2 -> getOutput().putPOJO("output", board.getPlayerTwoMana());
            default -> {

            }
        }
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

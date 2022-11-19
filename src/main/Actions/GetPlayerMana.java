package main.Actions;

import fileio.ActionsInput;
import main.Board;

public final class GetPlayerMana extends Action {
    public GetPlayerMana(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> getOutput().put("output", board.getPlayerOneMana());
            case 2 -> getOutput().put("output", board.getPlayerTwoMana());
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

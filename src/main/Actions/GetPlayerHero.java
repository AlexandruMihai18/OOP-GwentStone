package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.FormatOutput;

public final class GetPlayerHero extends Action {
    public GetPlayerHero(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().put("output", FormatOutput.formatHero(board.getPlayerOneHero()));
            }
            case 2 -> {
                getOutput().put("output", FormatOutput.formatHero(board.getPlayerTwoHero()));
            }
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

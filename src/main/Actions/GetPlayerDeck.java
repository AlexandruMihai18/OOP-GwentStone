package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;
import main.Helpers.FormatOutput;

public final class GetPlayerDeck extends Action {
    public GetPlayerDeck(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().put("output", FormatOutput.formatDeck(board.getPlayerOneDeck()));
            }
            case 2 -> {
                getOutput().put("output", FormatOutput.formatDeck(board.getPlayerTwoDeck()));
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

package actions;

import fileio.ActionsInput;
import helpers.FormatOutput;
import server.Board;

public final class GetPlayerDeck extends Action {
    public GetPlayerDeck(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().putPOJO("output", FormatOutput.formatDeck(board.getPlayerOneDeck()));
            }
            case 2 -> {
                getOutput().putPOJO("output", FormatOutput.formatDeck(board.getPlayerTwoDeck()));
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

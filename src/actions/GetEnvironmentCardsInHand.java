package actions;

import fileio.ActionsInput;
import helpers.FormatOutput;
import server.Board;

public final class GetEnvironmentCardsInHand extends Action {
    public GetEnvironmentCardsInHand(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().putPOJO("output",
                        FormatOutput.formatEnvironmentDeck(board.getPlayerOneHand()));
            }
            case 2 -> {
                getOutput().putPOJO("output",
                        FormatOutput.formatEnvironmentDeck(board.getPlayerTwoHand()));
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

package main.Actions;

import fileio.ActionsInput;
import main.Helpers.FormatOutput;
import main.Server.Board;

public final class GetEnvironmentCardsInHand extends Action {
    public GetEnvironmentCardsInHand(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().put("output",
                        FormatOutput.formatEnvironmentDeck(board.getPlayerOneHand()));
            }
            case 2 -> {
                getOutput().put("output",
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

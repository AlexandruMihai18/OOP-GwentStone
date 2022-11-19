package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.FormatOutput;

public final class GetCardsInHand extends Action {
    public GetCardsInHand(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().put("output", FormatOutput.formatDeck(board.getPlayerOneHand()));
            }
            case 2 -> {
                getOutput().put("output", FormatOutput.formatDeck(board.getPlayerTwoHand()));
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

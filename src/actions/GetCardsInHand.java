package actions;

import fileio.ActionsInput;
import helpers.DeckBuilder;
import helpers.FormatOutput;
import server.Board;

public final class GetCardsInHand extends Action {
    public GetCardsInHand(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {
        getOutput().putPOJO("command", getCommand());
        getOutput().putPOJO("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().putPOJO("output", FormatOutput
                        .formatDeck(DeckBuilder.deckCopy(board.getPlayerOneHand())));
            }
            case 2 -> {
                getOutput().putPOJO("output", FormatOutput
                        .formatDeck(DeckBuilder.deckCopy(board.getPlayerTwoHand())));
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

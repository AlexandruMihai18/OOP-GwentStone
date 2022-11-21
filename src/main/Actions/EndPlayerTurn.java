package main.Actions;

import fileio.ActionsInput;
import main.Server.Board;

import static main.Helpers.MagicNumbers.TURN_CHANGER;

public class EndPlayerTurn extends Action {
    public EndPlayerTurn(final ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(final Board board) {

    }

    @Override
    public void setError(final String error) {

    }

    /**
     * Ending a player's turn and beginning the new round by reseting all player's minions
     * and giving each player mana and card if 2 turns (a round) have passed.
     * @param board given board
     */
    @Override
    public void action(final Board board) {
        board.resetMinions();
        board.setTurn(TURN_CHANGER - board.getTurn());
        board.setTurnCounter();

        if (board.getTurnCounter() % 2 == 1) {
            return;
        }

        board.setManaGiven();

        board.setPlayerOneMana(board.getManaGiven());
        board.setPlayerOneHand();

        board.setPlayerTwoMana(board.getManaGiven());
        board.setPlayerTwoHand();
    }
}

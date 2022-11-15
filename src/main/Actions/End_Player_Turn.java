package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Minion;
import main.Game;

import java.util.ArrayList;

public class End_Player_Turn extends Action{
    public End_Player_Turn(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {

    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {
        unfrozen(board);
        board.setTurn(3 - board.getTurn());
        board.setTurnCounter();
        
        if (board.getTurnCounter() % 2 == 1)
            return;

        board.setManaGiven();

        board.setPlayerOneMana(board.getManaGiven());
        board.setPlayerOneHand();

        board.setPlayerTwoMana(board.getManaGiven());
        board.setPlayerTwoHand();
    }

    void unfrozen(Board board) {
        switch (board.getTurn()) {
            case 1 -> {
                unfrozenRow(board.getPlayerOneBackLane());
                unfrozenRow(board.getPlayerOneFrontLane());
            }
            case 2 -> {
                unfrozenRow(board.getPlayerTwoBackLane());
                unfrozenRow(board.getPlayerTwoFrontLane());
            }
            default -> throw new IllegalStateException("Unexpected value: " + board.getTurn());
        }
    }

    void unfrozenRow(ArrayList<Minion> row) {
        for (Minion card : row) {
            card.setFrozen(false);
            card.setUsed(false);
        }
    }
}

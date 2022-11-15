package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;

public class Get_Cards_In_Hand extends Action{
    public Get_Cards_In_Hand(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (this.getPlayerIdx()) {
            case 1 -> {
                showArray(game.getBoard().getPlayerOneHand());
                getOutput().put("output", getDeckOutput());
            }
            case 2 -> {
                showArray(game.getBoard().getPlayerTwoHand());
                getOutput().put("output", getDeckOutput());
            }
        }
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

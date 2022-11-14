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
            case 1:
                getOutput().put("output", game.getBoard().getPlayerOneHand().toString());
                break;
            case 2:
                getOutput().put("output", game.getBoard().getPlayerTwoHand().toString());
        }
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

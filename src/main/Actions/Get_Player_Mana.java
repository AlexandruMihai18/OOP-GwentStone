package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;

public class Get_Player_Mana extends Action {
    public Get_Player_Mana(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> getOutput().put("output", game.getBoard().getPlayerOneMana());
            case 2 -> getOutput().put("output", game.getBoard().getPlayerTwoMana());
            default -> throw new IllegalStateException("Unexpected value: " + getPlayerIdx());
        }
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

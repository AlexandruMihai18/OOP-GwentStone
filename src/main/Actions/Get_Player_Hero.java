package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;

public class Get_Player_Hero extends Action{
    public Get_Player_Hero(ActionsInput action) {
        super(action);
    }

    public void action(Board board) {}

    public void setOutput(Game game) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (getPlayerIdx()) {
            case 1 -> {
                getOutput().put("output", game.getBoard().getPlayerOneHero().printCard());
            }
            case 2 -> {
                getOutput().put("output", game.getBoard().getPlayerTwoHero().printCard());
            }
            default -> throw new IllegalStateException("Unexpected value: " + getPlayerIdx());
        }
    }

    @Override
    public void setError(String error) {

    }
}

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
        this.output = game.getGameStart().getPlayerOneHero();
    }

    @Override
    public String toString() {
        return "command=" + this.getCommand()
                + "playerIdx" + this.getPlayerIdx()
                + "output=" + output;
    }
}

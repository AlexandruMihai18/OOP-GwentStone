package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;

public class Get_Player_Turn extends Action{
    public Get_Player_Turn(ActionsInput action) {
        super(action);
    }

    public void action(Board board) {}


    public void setOutput(Game game) {
         this.output = game.getBoard().getTurn();
    }

    @Override
    public String toString() {
        return "command=" + this.getCommand()
                + "output=" + output;
    }
}

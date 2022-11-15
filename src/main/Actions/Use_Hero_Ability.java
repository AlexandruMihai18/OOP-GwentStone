package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;

public class Use_Hero_Ability extends Action{
    public Use_Hero_Ability(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {

    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("affectedRow", getAffectedRow());
        getOutput().put("error", error);
    }

    @Override
    public void action(Board board) {

    }
}

package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Card;
import main.Cards.Minion;
import main.Game;

import java.util.ArrayList;

public class Get_Cards_On_Table extends Action{
    public Get_Cards_On_Table(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        getOutput().put("command", getCommand());
        showTable(game.getBoard());
        getOutput().put("output", getTableOutput());
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

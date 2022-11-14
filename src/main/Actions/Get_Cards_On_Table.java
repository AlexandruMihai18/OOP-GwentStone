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
        ArrayList<ArrayList<Minion>> table = new ArrayList<>();
        table.add(game.getBoard().getPlayerTwoBackLane());
        table.add(game.getBoard().getPlayerTwoFrontLane());
        table.add(game.getBoard().getPlayerOneFrontLane());
        table.add(game.getBoard().getPlayerOneBackLane());
        getOutput().put("command", getCommand());
        getOutput().put("output", table.toString());
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Minion;
import main.Game;

import java.util.ArrayList;

public class Get_Frozen_Cards_On_Table extends Action{
    public Get_Frozen_Cards_On_Table(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        ArrayList<Minion> minionsFrozen = new ArrayList<>();

        for (Minion minion : game.getBoard().getPlayerTwoBackLane()) {
            if (minion.isFrozen())
                minionsFrozen.add(minion);
        }

        for (Minion minion : game.getBoard().getPlayerTwoFrontLane()) {
            if (minion.isFrozen())
                minionsFrozen.add(minion);
        }

        for (Minion minion : game.getBoard().getPlayerOneFrontLane()) {
            if (minion.isFrozen())
                minionsFrozen.add(minion);
        }

        for (Minion minion : game.getBoard().getPlayerOneBackLane()) {
            if (minion.isFrozen())
                minionsFrozen.add(minion);
        }

        getOutput().put("command", getCommand());
        getOutput().put("output", minionsFrozen.toString());
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

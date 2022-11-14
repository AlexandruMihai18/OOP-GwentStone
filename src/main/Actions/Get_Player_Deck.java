package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Game;



public class Get_Player_Deck extends Action{
    public Get_Player_Deck(ActionsInput action) {
        super(action);
    }

    public void action(Board board) {}

    public void setOutput(Game game) {
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        switch (this.getPlayerIdx()) {
            case 1:
                getOutput().put("output", game.getBoard().getPlayerOneDeck().toString());
                break;
            case 2:
                getOutput().put("output", game.getBoard().getPlayerTwoDeck().toString());
        }
    }

    @Override
    public void setError(String error) {

    }
}

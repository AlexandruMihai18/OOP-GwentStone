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
        switch (this.getPlayerIdx()) {
            case 1:
                this.output = game.getPlayerOneDeck();
            case 2:
                this.output = game.getPlayerTwoDeck();
        }
    }

}

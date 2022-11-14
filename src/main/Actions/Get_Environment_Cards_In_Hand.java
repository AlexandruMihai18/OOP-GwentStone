package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Card;
import main.Game;

import java.util.ArrayList;

public class Get_Environment_Cards_In_Hand extends Action{
    public Get_Environment_Cards_In_Hand(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        ArrayList<Card> environment = new ArrayList<>();
        ArrayList<Card> deck;
        switch(getPlayerIdx()) {
            case 1:
                deck = game.getBoard().getPlayerOneHand();
                break;
            case 2:
                deck = game.getBoard().getPlayerTwoHand();
                break;
            default:
                deck = null;
        }
        for (Card card : deck) {
            if (card.getType().equals("Environment"))
                environment.add(card);
        }
        getOutput().put("command", getCommand());
        getOutput().put("playerIdx", getPlayerIdx());
        getOutput().put("output", environment.toString());
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void action(Board board) {

    }
}

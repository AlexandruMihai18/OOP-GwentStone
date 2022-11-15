package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Card;
import main.Cards.Heart_Hound;
import main.Game;

public class Use_Environment_Card extends Action{

    public Use_Environment_Card(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {

    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("handIdx", getPlayerIdx());
        getOutput().put("affectedRow", getAffectedRow());
        getOutput().put("error", error);
    }

    @Override
    public void action(Board board) {
        Card card;
        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().get(getHandIdx());
        } else {
            card = board.getPlayerTwoHand().get(getHandIdx());
        }

        if (!card.getType().equals("Environment")) {
            setError("Chosen card is not of type environment.");
            return;
        }

        if (!enoughMana(board, card)) {
            setError("Not enough mana to use environment card.");
            return;
        }

        boolean validRow = true;
        if (board.getTurn() == 1) {
            if (getAffectedRow() == 2 || getAffectedRow() == 3)
                validRow = false;
        } else {
            if (getAffectedRow() == 0 || getAffectedRow() == 1)
                validRow = false;
        }

        if (!validRow) {
            setError("Chosen row does not belong to the enemy.");
            return;
        }

        if (card.getName().equals("Heart Hound") && !checkHeartHound(board)) {
            setError("Cannot steal enemy card since the player's row is full");
            return;
        }

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().remove(getHandIdx());
            board.setPlayerOneMana(-card.getMana());
        } else {
            card = board.getPlayerTwoHand().remove(getHandIdx());
            board.setPlayerTwoMana(-card.getMana());
        }

        card.ability(board, getAffectedRow());

        board.clearBoard();
    }

    public boolean enoughMana(Board board, Card card) {
        if (board.getTurn() == 1) {
            return card.getMana() <= board.getPlayerOneMana();
        } else {
            return card.getMana() <= board.getPlayerTwoMana();
        }
    }

    public boolean checkHeartHound(Board board) {
        switch (getAffectedRow()) {
            case 0:
                if (board.getPlayerOneBackLane().size() == 5)
                    return false;
                break;
            case 1:
                if (board.getPlayerOneFrontLane().size() == 5)
                    return false;
                break;
            case 2:
                if (board.getPlayerTwoFrontLane().size() == 5)
                    return false;
                break;
            case 3:
                if (board.getPlayerTwoBackLane().size() == 5)
                    return false;
                break;
        }
        return true;
    }
}

package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Card;
import main.Cards.Minion;
import main.Game;

public class Place_Card extends Action{
    public Place_Card(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {

    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("handIdx", getPlayerIdx());
        getOutput().put("output", error);
    }

    @Override
    public void action(Board board) {
        Card card;

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().get(getHandIdx());
        } else {
            card = board.getPlayerTwoHand().get(getHandIdx());
        }

        if (!enoughMana(board, card)) {
            setError("Not enough mana to place card on table");
            return;
        }

        if (!card.getType().equals("Minion")) {
            setError("Cannot place environment card on table.");
            return;
        }

        if (isFull(board, card)) {
          setError("Cannot place card on table since row is full.");
          return;
        }

        if (board.getTurn() == 1) {
            card = board.getPlayerOneHand().remove(getHandIdx());
            if (((Minion)card).getRequiredRow() == 0) {
                board.getPlayerOneBackLane().add((Minion)card);
            } else {
                board.getPlayerOneFrontLane().add((Minion)card);
            }
            board.setPlayerOneMana(-card.getMana());
        } else {
            card = board.getPlayerTwoHand().remove(getHandIdx());
            if (((Minion)card).getRequiredRow() == 0) {
                board.getPlayerTwoBackLane().add((Minion)card);
            } else {
                board.getPlayerTwoFrontLane().add((Minion)card);
            }
            board.setPlayerTwoMana(-card.getMana());
        }
    }

    public boolean isFull(Board board, Card card) {
        if (board.getTurn() == 1) {
            if (((Minion)card).getRequiredRow() == 0 && board.getPlayerOneBackLane().size() == 5)
                return true;
            if (((Minion)card).getRequiredRow() == 1 && board.getPlayerOneFrontLane().size() == 5)
                return true;
        }
        if (board.getTurn() == 2) {
            if (((Minion)card).getRequiredRow() == 0 && board.getPlayerTwoBackLane().size() == 5)
                return true;
            return ((Minion) card).getRequiredRow() == 1 && board.getPlayerTwoFrontLane().size() == 5;
        }
        return false;
    }

    public boolean enoughMana(Board board, Card card) {
        if (board.getTurn() == 1) {
            return card.getMana() <= board.getPlayerOneMana();
        } else {
            return card.getMana() <= board.getPlayerTwoMana();
        }
    }
}

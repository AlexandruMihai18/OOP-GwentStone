package main.Actions;

import fileio.ActionsInput;
import main.Board;
import main.Cards.Card;
import main.Game;

public class Get_Card_At_Position extends Action{
    public Get_Card_At_Position(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
        if (!isCard(game.getBoard(), getX(), getY())) {
            setError("No card at that position.");
            return;
        }

        Card card = switch (getX()) {
            case 0 -> game.getBoard().getPlayerTwoBackLane().get(getY());
            case 1 -> game.getBoard().getPlayerTwoFrontLane().get(getY());
            case 2 -> game.getBoard().getPlayerOneFrontLane().get(getY());
            default -> game.getBoard().getPlayerOneBackLane().get(getY());
        };

        getOutput().put("command", getCommand());
        getOutput().put("output", card.toString());
    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("output", error);
    }

    @Override
    public void action(Board board) {

    }

    public boolean isCard(Board board, int x, int y) {
        switch(x) {
            case 0:
                if (board.getPlayerTwoBackLane().size() <= y)
                    return false;
                break;
            case 1:
                if (board.getPlayerTwoFrontLane().size() <= y)
                    return false;
                break;
            case 2:
                if (board.getPlayerOneFrontLane().size() <= y)
                    return false;
                break;
            case 3:
                if (board.getPlayerOneBackLane().size() <= y)
                    return false;
                break;
        }
        return true;
    }
}

package main.Cards;

import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public class Winterfell extends Environment{
    public Winterfell(CardInput card) {
        super(card);
    }

    public void ability(Board board, int row) {
        ArrayList<Minion> affectedRow;
        switch(row) {
            case 0:
                affectedRow = board.getPlayerTwoBackLane();
                break;
            case 1:
                affectedRow = board.getPlayerTwoFrontLane();
                break;
            case 2:
                affectedRow = board.getPlayerOneFrontLane();
                break;
            default:
                affectedRow = board.getPlayerOneBackLane();
                break;
        }
        for (Minion card : affectedRow) {
            card.setFrozen(true);
        }
    }
}

package main.Cards;

import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public class Heart_Hound extends Environment{
    public Heart_Hound(CardInput card) {
        super(card);
    }

    public void ability(ArrayList<Minion> row) {
    }

    public void ability(Board board, int row) {
        switch (row) {
            case 0 -> board.getPlayerOneBackLane().add(findHighestHealth(board.getPlayerTwoBackLane()));
            case 1 -> board.getPlayerOneFrontLane().add(findHighestHealth(board.getPlayerTwoFrontLane()));
            case 2 -> board.getPlayerTwoFrontLane().add(findHighestHealth(board.getPlayerOneFrontLane()));
            default -> board.getPlayerTwoBackLane().add(findHighestHealth(board.getPlayerOneBackLane()));
        }
    }

    public Minion findHighestHealth(ArrayList<Minion> row) {
        Minion minion = row.get(0);
        for (Minion card : row) {
            if (minion.getHealth() < card.getHealth())
                minion = card;
        }
        row.remove(minion);
        return minion;
    }
}

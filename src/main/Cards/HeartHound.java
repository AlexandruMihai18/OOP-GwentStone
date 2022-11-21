package main.Cards;

import fileio.CardInput;
import main.Server.Board;

import java.util.ArrayList;

import static main.Helpers.MagicNumbers.NUMBER_LANES;

public final class HeartHound extends Environment {
    public HeartHound(final CardInput card) {
        super(card);
    }

    public HeartHound(final Card card) {
        super(card);
    }

    @Override
    public void ability(final ArrayList<Minion> row) {

    }

    /**
     * Heart Hound's ability steals the card with the highest health on a lane
     * and transfers it to an ally lane
     * @param board given board
     * @param row affected row
     */
    public void ability(final Board board, final int row) {
        board.getLanes().get(NUMBER_LANES - 1 - row)
                .add(findHighestHealth(board.getLanes().get(row)));
    }

    /**
     * Finds and removes the highest health minion on a lane
     * @param lane given lane
     * @return highest health minion on the specified lane
     */
    public Minion findHighestHealth(final ArrayList<Minion> lane) {
        Minion minionHighestHealth = lane.get(0);
        for (Minion minion : lane) {
            if (minionHighestHealth.getHealth() < minion.getHealth()) {
                minionHighestHealth = minion;
            }
        }
        lane.remove(minionHighestHealth);
        return minionHighestHealth;
    }
}

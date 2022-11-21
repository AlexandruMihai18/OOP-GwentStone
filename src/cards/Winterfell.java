package cards;

import fileio.CardInput;

import java.util.ArrayList;

public final class Winterfell extends Environment {
    public Winterfell(final CardInput card) {
        super(card);
    }
    public Winterfell(final Card card) {
        super(card);
    }

    /**
     * Winterfell's ability freezes all cards on a row
     * @param lane affected lane
     */
    public void ability(final ArrayList<Minion> lane) {
        for (Minion card : lane) {
            card.setFrozen(true);
        }
    }
}

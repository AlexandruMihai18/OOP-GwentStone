package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public final class Firestorm extends Environment {
    public Firestorm(final CardInput card) {
        super(card);
    }
    public Firestorm(final Card card) {
        super(card);
    }

    /**
     * Firestorm card decreases the health of all cards on a row by 1
     * @param lane affected lane
     */
    @Override
    public void ability(final ArrayList<Minion> lane) {
        for (Minion minion : lane) {
            minion.setHealth(-1);
        }
    }
}

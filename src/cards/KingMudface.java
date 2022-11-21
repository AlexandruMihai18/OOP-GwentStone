package cards;

import fileio.CardInput;

import java.util.ArrayList;

import static helpers.MagicNumbers.MUDFACE_HEALTH;

public final class KingMudface extends Hero {
    public KingMudface(final CardInput card) {
        super(card);
    }

    /**
     * King Mudafce's ability increases the health of all cards on an ally row by 1
     * @param lane affected lane
     */
    public void ability(final ArrayList<Minion> lane) {
        for (Minion minion : lane) {
            minion.setHealth(MUDFACE_HEALTH);
        }
    }
}

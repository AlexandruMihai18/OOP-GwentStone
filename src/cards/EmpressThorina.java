package cards;

import fileio.CardInput;

import java.util.ArrayList;

public final class EmpressThorina extends Hero {
    public EmpressThorina(final CardInput card) {
        super(card);
    }

    /**
     * Empress Thorina's ability finds the highest health enemy on a row and destroys it
     * @param lane affected lane
     */
    @Override
    public void ability(final ArrayList<Minion> lane) {
        Minion mostHealthMinion = lane.get(0);

        for (Minion minion : lane) {
            if (minion.getHealth() > mostHealthMinion.getAttackDamage()) {
                mostHealthMinion = minion;
            }
        }

        lane.remove(mostHealthMinion);
    }
}

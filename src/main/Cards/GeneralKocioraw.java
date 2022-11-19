package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public final class GeneralKocioraw extends Hero {
    public GeneralKocioraw(final CardInput card) {
        super(card);
    }

    /**
     * General Kocioraw's ability increases the attack damage of all cards on an ally row by 1
     * @param lane affected lane
     */
    @Override
    public void ability(final ArrayList<Minion> lane) {
        for (Minion minion : lane) {
            minion.setAttackDamage(1);
        }
    }
}

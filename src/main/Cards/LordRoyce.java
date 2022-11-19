package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public final class LordRoyce extends Hero {
    public LordRoyce(final CardInput card) {
        super(card);
    }

    /**
     * Lord Royce's ability freezes the card with the most attack damage on an enemy row
     * @param lane affected lane
     */
    public void ability(final ArrayList<Minion> lane) {
        Minion mostAttack = lane.get(0);

        for (Minion minion : lane) {
            if (minion.getAttackDamage() > mostAttack.getAttackDamage()) {
                mostAttack = minion;
            }
        }

        mostAttack.setFrozen(true);
    }
}

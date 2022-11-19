package main.Cards;

import fileio.CardInput;

public final class TheCursedOne extends Minion {
    public TheCursedOne(final CardInput card, final int requiredRow) {
        super(card, requiredRow);
    }
    public TheCursedOne(final Card card, final int requiredRow) {
        super(card, requiredRow);
    }

    /**
     * The Cursed One's ability swaps a card health and attack damage
     * @param minion affect card
     */
    public void ability(final Minion minion) {
        int tmpHealth = minion.getHealth();
        int tmpAttackDamage = minion.getAttackDamage();
        minion.setHealth(-tmpHealth + tmpAttackDamage);
        minion.setAttackDamage(-tmpAttackDamage + tmpHealth);
    }
}

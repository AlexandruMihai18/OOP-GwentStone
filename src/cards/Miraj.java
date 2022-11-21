package cards;

import fileio.CardInput;

public final class Miraj extends Minion {
    public Miraj(final CardInput card, final int requiredRow) {
        super(card, requiredRow);
    }
    public Miraj(final Card card, final int requiredRow) {
        super(card, requiredRow);
    }

    /**
     * Miraj's ability swaps it's health with the enemy health
     * @param minion affect card
     */
    public void ability(final Minion minion) {
        int tmpMyHealth = this.getHealth();
        int tmpEnemyHealth = minion.getHealth();
        this.setHealth(-tmpMyHealth + tmpEnemyHealth);
        minion.setHealth(-tmpEnemyHealth + tmpMyHealth);
    }
}

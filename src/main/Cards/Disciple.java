package main.Cards;

import fileio.CardInput;

public final class Disciple extends Minion {
    public Disciple(final CardInput card, final int requiredRow) {
        super(card, requiredRow);
    }
    public Disciple(final Card card, final int requiredRow) {
        super(card, requiredRow);
    }

    /**
     * Disciple card adds 2 health to an ally card
     * @param minion ally minion
     */
    @Override
    public void ability(final Minion minion) {
        minion.setHealth(2);
    }
}

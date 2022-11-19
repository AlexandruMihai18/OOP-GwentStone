package main.Cards;

import fileio.CardInput;

import static main.MagicNumbers.RIPPER;

public final class TheRipper extends Minion {
    public TheRipper(final CardInput card, final int requiredRow) {
        super(card, requiredRow);
    }
    public TheRipper(final Card card, final int requiredRow) {
        super(card, requiredRow);
    }

    /**
     * The Ripper's ability decreases the attack damage of a card by 2
     * @param minion affect card
     */
    public void ability(final Minion minion) {
        if (minion.getAttackDamage() < 2) {
            minion.setAttackDamage(minion.getAttackDamage());
        } else {
            minion.setAttackDamage(RIPPER);
        }
    }
}

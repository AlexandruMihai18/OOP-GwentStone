package main.Cards;

import fileio.CardInput;

public class The_Ripper extends Minion{
    public The_Ripper(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }

    public void ability(Card card) {
        card.setAttackDamage(-2);
    }
}

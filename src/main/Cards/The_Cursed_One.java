package main.Cards;

import fileio.CardInput;

public class The_Cursed_One extends Minion{
    public The_Cursed_One(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }
    public void ability(Card card) {
        int tmp = card.getHealth();
        card.setHealth(-tmp + card.getAttackDamage());
        card.setAttackDamage(-card.getAttackDamage() + tmp);
    }
}

package main.Cards;

import fileio.CardInput;

public class Miraj extends Minion{
    public Miraj(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }

    public void ability(Card card) {
        int tmp = this.getHealth();
        this.setHealth(-tmp + card.getHealth());
        card.setHealth(-card.getHealth() + tmp);
    }
}

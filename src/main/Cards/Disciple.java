package main.Cards;

import fileio.CardInput;

public class Disciple extends Minion{
    public Disciple(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }
    public void ability(Card card) {
        card.setHealth(2);
    }
}

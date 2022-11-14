package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Winterfell extends Environment{
    public Winterfell(CardInput card) {
        super(card);
    }

    public void ability(ArrayList<Minion> row) {
        for (Minion card : row) {
            card.setFrozen(true);
        }
    }
}

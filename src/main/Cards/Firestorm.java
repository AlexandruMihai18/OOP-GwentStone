package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Firestorm extends Environment{
    public Firestorm(CardInput card) {
        super(card);
    }

    public void ability(ArrayList<Minion> row) {
        for (Minion card : row) {
            card.setHealth(-1);
        }
    }
}

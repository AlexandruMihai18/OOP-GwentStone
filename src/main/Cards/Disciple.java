package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Disciple extends Minion{
    public Disciple(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }
    public void ability(ArrayList<Minion> lane, int row) {
        lane.get(row).setHealth(2);
    }
}

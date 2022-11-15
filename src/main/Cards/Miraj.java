package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Miraj extends Minion{
    public Miraj(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }

    public void ability(ArrayList<Minion> lane, int row) {
        int tmpMyHealth = this.getHealth();
        int tmpEnemyHealth = lane.get(row).getHealth();
        this.setHealth(-tmpMyHealth + tmpEnemyHealth);
        lane.get(row).setHealth(-tmpEnemyHealth+ tmpMyHealth);
    }
}

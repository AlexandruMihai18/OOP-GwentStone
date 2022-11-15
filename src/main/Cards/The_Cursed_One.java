package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class The_Cursed_One extends Minion{
    public The_Cursed_One(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }

    public void ability(ArrayList<Minion> lane, int row) {
        int tmpHealth = lane.get(row).getHealth();
        int tmpAttackDamage = lane.get(row).getAttackDamage();
        lane.get(row).setHealth(-tmpHealth + tmpAttackDamage);
        lane.get(row).setAttackDamage(-tmpAttackDamage + tmpHealth);
    }
}

package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class The_Ripper extends Minion{
    public The_Ripper(CardInput card, int requiredRow) {
        super(card, requiredRow);
    }

    public void ability(ArrayList<Minion> lane, int row) {
        if (lane.get(row).getAttackDamage() < 2)
            lane.get(row).setAttackDamage(lane.get(row).getAttackDamage());
        else
            lane.get(row).setAttackDamage(-2);
    }
}

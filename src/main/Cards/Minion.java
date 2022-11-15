package main.Cards;

import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public class Minion extends Card {
    private boolean frozen;
    private boolean used;

    private boolean taunt = false;
    private int requiredRow;

    public Minion(CardInput card, int requiredRow) {
        super(card);
        setType("Minion");
        this.requiredRow = requiredRow;
    }
    public Minion(CardInput card, boolean taunt, int requiredRow) {
        super(card);
        setType("Minion");
        this.taunt = taunt;
        this.requiredRow = requiredRow;
    }
    public Minion(Card card) {
        super(card);
    }
    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public int getRequiredRow() {
        return requiredRow;
    }

    @Override
    public void ability(Board board, int row) {}

    public void ability(ArrayList<Minion> lane, int row) {}

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("attackDamage", getAttackDamage());
        getCardOutput().put("health", getHealth());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", formatColors());
        getCardOutput().put("name", getName());
    }
}

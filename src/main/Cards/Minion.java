package main.Cards;

import fileio.CardInput;

public class Minion extends Card {
    private boolean frozen;
    private boolean taunt = false;
    private int requiredRow;

    public Minion(CardInput card, int requiredRow) {
        super(card);
        this.requiredRow = requiredRow;
    }
    public Minion(CardInput card, boolean taunt, int requiredRow) {
        super(card);
        this.taunt = taunt;
        this.requiredRow = requiredRow;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    @Override
    public void action() {}
}

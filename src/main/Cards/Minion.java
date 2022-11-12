package main.Cards;

import fileio.CardInput;

public class Minion extends Card {
    private boolean frozen;
    private boolean taunt;

    public Minion(CardInput card) {
        super(card);
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

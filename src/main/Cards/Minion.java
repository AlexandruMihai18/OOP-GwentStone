package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Minion extends Card {
    private boolean frozen;
    private boolean used;
    private boolean tank = false;
    private int requiredRow;

    public Minion(final CardInput card, final int requiredRow) {
        super(card);
        setType("Minion");
        this.requiredRow = requiredRow;
    }
    public Minion(final CardInput card, final boolean tank, final int requiredRow) {
        super(card);
        setType("Minion");
        this.tank = tank;
        this.requiredRow = requiredRow;
    }
    public Minion(final Card card) {
        super(card);
        setType("Minion");
    }
    public Minion(final Card card, final int requiredRow) {
        super(card);
        setType("Minion");
        this.requiredRow = requiredRow;
    }
    public Minion(final Card card, final boolean tank, final int requiredRow) {
        super(card);
        setType("Minion");
        this.tank = tank;
        this.requiredRow = requiredRow;
    }
    public final boolean isFrozen() {
        return frozen;
    }

    public final void setFrozen(final boolean frozen) {
        this.frozen = frozen;
    }

    public final boolean isUsed() {
        return used;
    }

    public final void setUsed(final boolean used) {
        this.used = used;
    }

    public final boolean isTank() {
        return tank;
    }

    public final void setTank(final boolean tank) {
        this.tank = tank;
    }

    public final int getRequiredRow() {
        return requiredRow;
    }

    @Override
    public void ability(final ArrayList<Minion> lane) {

    }

    /**
     * Special minions affect only a single card instead of an entire row
     * @param minion affect card
     */
    public void ability(final Minion minion) {

    }
}

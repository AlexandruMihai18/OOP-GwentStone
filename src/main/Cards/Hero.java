package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

import static main.Helpers.MagicNumbers.HERO_HEALTH;

public class Hero extends Card {
    private boolean used;
    public Hero(final CardInput card) {
        super(card);
        setHealth(HERO_HEALTH);
        setType("Hero");
    }

    public Hero(final Card card) {
        super(card);
        setType("Hero");
    }

    public final boolean isUsed() {
        return used;
    }

    public final void setUsed(final boolean used) {
        this.used = used;
    }

    @Override
    public void ability(final ArrayList<Minion> lane) {

    }
}

package cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Environment extends Card {
    public Environment(final CardInput card) {
        super(card);
        setType("Environment");
    }

    public Environment(final Card card) {
        super(card);
        setType("Environment");
    }

    @Override
    public void ability(final ArrayList<Minion> lane) {

    }
}

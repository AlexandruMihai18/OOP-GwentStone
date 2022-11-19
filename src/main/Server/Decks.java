package main.Server;

import main.Cards.Card;
import fileio.CardInput;
import fileio.DecksInput;
import main.Helpers.DeckBuilder;

import java.util.ArrayList;

public final class Decks {

    private ArrayList<ArrayList<Card>> decks = new ArrayList<>();

    public Decks(final DecksInput decksInput) {
        setDecks(decksInput.getDecks());
    }

    public ArrayList<ArrayList<Card>> getDecks() {
        return decks;
    }

    public void setDecks(final ArrayList<ArrayList<CardInput>> decksInput) {
        this.decks = DeckBuilder.buildDecks(decksInput);
    }

}

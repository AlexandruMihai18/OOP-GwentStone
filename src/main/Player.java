package main;

import main.Cards.Card;
import fileio.CardInput;
import fileio.DecksInput;
import main.Cards.*;

import java.util.ArrayList;
import static main.CardTypeEnum.*;

public class Player {
    private int nrCardsInDeck;

    private int nrDecks;

    private final ArrayList<ArrayList<Card>> decks = new ArrayList<>();

    public Player(DecksInput player) {
        setNrCardsInDeck(player.getNrCardsInDeck());
        setNrDecks(player.getNrDecks());
        setDecks(player.getDecks());
    }

    public int getNrCardsInDeck() {
        return nrCardsInDeck;
    }

    public void setNrCardsInDeck(int nrCardsInDeck) {
        this.nrCardsInDeck = nrCardsInDeck;
    }

    public int getNrDecks() {
        return nrDecks;
    }

    public void setNrDecks(int nrDecks) {
        this.nrDecks = nrDecks;
    }

    public ArrayList<ArrayList<Card>> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<ArrayList<CardInput>> decks) {
        for (ArrayList<CardInput> deck : decks) {
            ArrayList<Card> newDeck = buildDeck(deck);
            this.decks.add(newDeck);
        }
    }

    public ArrayList<Card> buildDeck(ArrayList<CardInput> deck) {
        ArrayList<Card> buildDeck= new ArrayList<>();
        for (CardInput cardInput : deck) {
            Card newCard = buildCard(cardInput);
            buildDeck.add(newCard);
        }
        return buildDeck;
    }

    public Card buildCard(CardInput card) {
        return switch (card.getName()) {
            case SENTINEL -> new Minion(card, 0);
            case BERSERKER -> new Minion(card, 1);
            case GOLIATH -> new Minion(card, true, 1);
            case WARDEN -> new Minion(card, true, 1);
            case THE_RIPPER -> new The_Ripper(card, 1);
            case MIRAJ -> new Miraj(card, 1);
            case THE_CURSED_ONE -> new The_Cursed_One(card, 0);
            case DISCIPLE -> new Disciple(card, 0);
            case FIRESTORM -> new Firestorm(card);
            case WINTERFELL -> new Winterfell(card);
            case HEART_HOUND -> new Heart_Hound(card);
            default -> null;
        };
    }
}

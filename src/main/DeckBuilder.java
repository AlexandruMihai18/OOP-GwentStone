package main;

import fileio.CardInput;
import main.Cards.*;
import static main.CardTypeEnum.*;

import java.util.ArrayList;

public final class DeckBuilder {
    private DeckBuilder() {

    }

    /**
     * Deep copying decks from input
     * @param decksInput input decks provided through JSON format
     * @return - decks of card
     */
    public static ArrayList<ArrayList<Card>>
        buildDecks(final ArrayList<ArrayList<CardInput>> decksInput) {
            ArrayList<ArrayList<Card>> newDecks = new ArrayList<>();

            for (ArrayList<CardInput> deckInput : decksInput) {
                ArrayList<Card> newDeck = buildDeck(deckInput);
                newDecks.add(newDeck);
            }

            return newDecks;
        }

    /**
     * Deep copying deck from input
     * @param deckInput input deck provided through JSON format
     * @return - deck of card
     */
    public static ArrayList<Card> buildDeck(final ArrayList<CardInput> deckInput) {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (CardInput cardInput : deckInput) {
            Card newCard = buildCard(cardInput);
            newDeck.add(newCard);
        }

        return newDeck;
    }

    /**
     * Deep copying and assigning specific card type from input
     * @param cardInput input card provided through JSON format
     * @return - card
     */
    public static Card buildCard(final CardInput cardInput) {
        return switch (cardInput.getName()) {
            case SENTINEL -> new Minion(cardInput, 0);
            case BERSERKER -> new Minion(cardInput, 0);
            case GOLIATH -> new Minion(cardInput, true, 1);
            case WARDEN -> new Minion(cardInput, true, 1);
            case THE_RIPPER -> new TheRipper(cardInput, 1);
            case MIRAJ -> new Miraj(cardInput, 1);
            case THE_CURSED_ONE -> new TheCursedOne(cardInput, 0);
            case DISCIPLE -> new Disciple(cardInput, 0);
            case FIRESTORM -> new Firestorm(cardInput);
            case WINTERFELL -> new Winterfell(cardInput);
            case HEART_HOUND -> new HeartHound(cardInput);
            default -> null;
        };
    }

    /**
     * Deep copying the deck in order to not cause conflicts between games
     * @param deckInput deck of cards
     * @return - deck of cards
     */
    public static ArrayList<Card> deckCopy(final ArrayList<Card> deckInput) {
        ArrayList<Card> newDeck = new ArrayList<>();

        for (Card cardInput : deckInput) {
            Card newCard = cardCopy(cardInput);
            newDeck.add(newCard);
        }

        return newDeck;
    }

    /**
     * Deep copying the card in order to not cause conflicts between decks
     * @param cardInput card
     * @return - card
     */
    public static Card cardCopy(final Card cardInput) {
        return switch (cardInput.getName()) {
            case SENTINEL -> new Minion(cardInput, 0);
            case BERSERKER -> new Minion(cardInput, 0);
            case GOLIATH -> new Minion(cardInput, true, 1);
            case WARDEN -> new Minion(cardInput, true, 1);
            case THE_RIPPER -> new TheRipper(cardInput, 1);
            case MIRAJ -> new Miraj(cardInput, 1);
            case THE_CURSED_ONE -> new TheCursedOne(cardInput, 0);
            case DISCIPLE -> new Disciple(cardInput, 0);
            case FIRESTORM -> new Firestorm(cardInput);
            case WINTERFELL -> new Winterfell(cardInput);
            case HEART_HOUND -> new HeartHound(cardInput);
            default -> null;
        };
    }

    /**
     * Deep copying the hero provided and assigning a subrole
     * @param hero player hero, in JSON format
     * @return hero
     */
    public static Hero buildHero(final CardInput hero) {
        return switch (hero.getName()) {
            case LORD_ROYCE -> new LordRoyce(hero);
            case EMPRESS_THORINA -> new EmpressThorina(hero);
            case KING_MUDFACE -> new KingMudface(hero);
            case GENERAL_KOCIORAW -> new GeneralKocioraw(hero);
            default -> null;
        };
    }
}

package main.Cards;

import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public class Hero extends Card {
    public Hero(CardInput card) {
        super(card);
        setHealth(30);
        setType("Hero");
    }

    public Hero(Card card) {
        super(card);
    }

    public void ability(Board board, int row) {}

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", formatColors());
        getCardOutput().put("name", getName());
        getCardOutput().put("health", getHealth());
    }
}

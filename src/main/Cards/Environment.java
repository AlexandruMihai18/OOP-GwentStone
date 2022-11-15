package main.Cards;

import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public class Environment extends Card{
    public Environment(CardInput card) {
        super(card);
        setType("Environment");
    }

    public Environment(Card card) {
        super(card);
    }

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", formatColors());
        getCardOutput().put("name", getName());
    }

    @Override
    public void ability(Board board, int row) {
    }
}

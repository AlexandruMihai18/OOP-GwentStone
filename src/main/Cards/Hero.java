package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Hero extends Card {
    public Hero(CardInput card) {
        super(card);
        setType("Hero");
    }

    public Hero(Card card) {
        super(card);
    }

    public void ability(ArrayList<Minion> row) {}

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", getColors().toString());
        getCardOutput().put("name", getName());
        getCardOutput().put("health", getHealth());
    }

    @Override
    public String toString() {
        return "{" +
                "mana=" + getMana() +
                ", description='" + getDescription() + '\'' +
                ", colors=" + getColors() +
                ", name='" + getName() +
                ", health=" + getHealth() +
                '}';
    }
}

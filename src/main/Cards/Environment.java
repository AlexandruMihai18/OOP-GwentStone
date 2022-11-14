package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public abstract class Environment extends Card{
    public Environment(CardInput card) {
        super(card);
        setType("Environment");
    }

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", getColors().toString());
        getCardOutput().put("name", getName());
    }

    @Override
    public void ability(ArrayList<Minion> row) {}

    @Override
    public String toString() {
        return "{" +
                "mana=" + getMana() +
                ", description='" + getDescription() + '\'' +
                ", colors=" + getColors() +
                ", name='" + getName() +
                '}';
    }
}

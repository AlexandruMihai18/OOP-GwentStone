package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public class Minion extends Card {
    private boolean frozen;
    private boolean taunt = false;
    private int requiredRow;

    public Minion(CardInput card, int requiredRow) {
        super(card);
        setType("Minion");
        this.requiredRow = requiredRow;
    }
    public Minion(CardInput card, boolean taunt, int requiredRow) {
        super(card);
        setType("Minion");
        this.taunt = taunt;
        this.requiredRow = requiredRow;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }

    public int getRequiredRow() {
        return requiredRow;
    }

    @Override
    public void ability(ArrayList<Minion> row) {}

    public void ability(Card card) {}

    public void showCard() {
        getCardOutput().put("mana", getMana());
        getCardOutput().put("attackDamage", getAttackDamage());
        getCardOutput().put("health", getHealth());
        getCardOutput().put("description", getDescription());
        getCardOutput().put("colors", getColors().toString());
        getCardOutput().put("name", getName());
    }

    @Override
    public String toString() {
        return "{" +
                "mana=" + getMana() +
                ", attackDamage=" + getAttackDamage() +
                ", health=" + getHealth() +
                ", description='" + getDescription() + '\'' +
                ", colors=" + getColors() +
                ", name='" + getName() +
                '}';
    }
}

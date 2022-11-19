package main.Cards;

import fileio.CardInput;

import java.util.ArrayList;

public abstract class Card {
    private String type;
    private int mana;
    private int attackDamage;
    private int health;
    private final String description;
    private final ArrayList<String> colors;
    private String name;

    public Card(final CardInput card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public Card(final Card card) {
        this.type = card.getType();
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final int getMana() {
        return mana;
    }

    /**
     * Incrementing the mana cost of a card
     * @param mana additional mana required for a card
     */
    public final void setMana(final int mana) {
        this.mana += mana;
    }

    public final int getAttackDamage() {
        return attackDamage;
    }

    /**
     * Incrementing the attack damage of a card
     * @param attackDamage additional attack damage implemented for a card
     */
    public final void setAttackDamage(final int attackDamage) {
        this.attackDamage += attackDamage;
    }

    public final int getHealth() {
        return health;
    }

    /**
     * Incrementing the health of a card
     * @param health additional health added for a card
     */
    public final void setHealth(final int health) {
        this.health += health;
    }

    public final String getDescription() {
        return description;
    }

    public final ArrayList<String> getColors() {
        return colors;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Card ability coresponding to each card type (Minion, Environment, Hero)
     * @param lane affected lane
     */
    public abstract void ability(ArrayList<Minion> lane);
}

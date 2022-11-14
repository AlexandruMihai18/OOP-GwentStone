package main.Cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;
import main.Board;

import java.util.ArrayList;

public abstract class Card {
    private String type;
    private int mana;
    private int attackDamage;
    private int health;
    private String description;
    private ArrayList<String> colors;
    private String name;

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectNode cardOutput = mapper.createObjectNode();

    public Card(CardInput card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public Card(Card card) {
        this.type = card.getType();
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana += mana;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage += attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectNode getCardOutput() {
        return cardOutput;
    }

    public abstract void ability(ArrayList<Minion> row);

    public abstract void showCard();

}

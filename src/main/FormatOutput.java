package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;
import main.Cards.Card;
import main.Cards.Environment;
import main.Cards.Hero;
import main.Cards.Minion;

import java.util.ArrayList;

public final class FormatOutput {
    private static ObjectMapper mapper = new ObjectMapper();

    private FormatOutput() {

    }

    /**
     * JSON formatting the colors of a card
     * @param colors colors of a card
     * @return ArrayNode JSON formatted object containing the colors
     */
    public static ArrayNode formatColors(final ArrayList<String> colors) {
        ArrayNode colorsNode = mapper.createArrayNode();
        for (String color : colors) {
            colorsNode.add(color);
        }
        return colorsNode;
    }

    /**
     * JSON formatting the fields of a Minion type card
     * @param minion Minion type card
     * @return ObjectNode JSON formatted object containing Minion class fields
     */
    public static ObjectNode formatMinion(final Minion minion) {
        ObjectNode minionNode = mapper.createObjectNode();
        minionNode.put("mana", minion.getMana());
        minionNode.put("attackDamage", minion.getAttackDamage());
        minionNode.put("health", minion.getHealth());
        minionNode.put("description", minion.getDescription());
        minionNode.put("colors", formatColors(minion.getColors()));
        minionNode.put("name", minion.getName());
        return minionNode;
    }

    /**
     * JSON formatting an Environment type card
     * @param environment Environment type card
     * @return ObjectNode JSON formatted object containing Environment class fields
     */
    public static ObjectNode formatEnvironment(final Environment environment) {
        ObjectNode environmentNode = mapper.createObjectNode();
        environmentNode.put("mana", environment.getMana());
        environmentNode.put("description", environment.getDescription());
        environmentNode.put("colors", formatColors(environment.getColors()));
        environmentNode.put("name", environment.getName());
        return environmentNode;
    }

    /**
     * JSON formating a Hero type card
     * @param hero Hero type card
     * @return ObjectNode JSON formatted object containing Hero Class fields
     */
    public static ObjectNode formatHero(final Hero hero) {
        ObjectNode heroNode = mapper.createObjectNode();
        heroNode.put("mana", hero.getMana());
        heroNode.put("description", hero.getDescription());
        heroNode.put("colors", formatColors(hero.getColors()));
        heroNode.put("name", hero.getName());
        heroNode.put("health", hero.getHealth());
        return heroNode;
    }

    /**
     * JSON formating a deck of cards
     * @param deck deck of cards
     * @return ArrayNode JSON formatted object containing the cards inside the deck
     */
    public static ArrayNode formatDeck(final ArrayList<Card> deck) {
        ArrayNode deckNode = mapper.createArrayNode();
        for (Card card : deck) {
            switch (card.getType()) {
                case "Environment":
                    deckNode.add(formatEnvironment((Environment) card));
                    break;
                case "Minion":
                    deckNode.add(formatMinion((Minion) card));
                    break;
                default:
            }
        }
        return deckNode;
    }

    /**
     * JSON formating a deck of cards, considering only the Environment cards
     * @param deck deck of cards
     * @return ArrayNode JSON formatted object containing only the Environmnet cards from the deck
     */
    public static ArrayNode formatEnvironmentDeck(final ArrayList<Card> deck) {
        ArrayNode environmentDeckNode = mapper.createArrayNode();
        for (Card card : deck) {
            if (card.getType().equals("Environment")) {
                environmentDeckNode.add(formatEnvironment((Environment) card));
            }
        }
        return environmentDeckNode;
    }

    /**
     * JSON formating a deck of card, considering only the frozen cards from the board
     * @param lanes board lanes
     * @return ArrayNode JSON formatted object containing only the frozen cards from the board
     */
    public static ArrayNode formatFrozenCards(final ArrayList<ArrayList<Minion>> lanes) {
        ArrayNode frozenNode = mapper.createArrayNode();
        for (ArrayList<Minion> lane : lanes) {
            for (Minion minion : lane) {
                if (minion.isFrozen()) {
                    frozenNode.add(formatMinion(minion));
                }
            }
        }
        return frozenNode;
    }

    /**
     * JSON formating a deck of card, considering only Minion cards on a lane
     * @param lane lane from the board
     * @return ArrayNode JSON formatted object containing Minion cards of the lane
     */
    public static ArrayNode formatLane(final ArrayList<Minion> lane) {
        ArrayNode laneNode = mapper.createArrayNode();
        for (Minion minion : lane) {
            laneNode.add(formatMinion(minion));
        }
        return laneNode;
    }

    /**
     * JSON formating a deck of card, considering only Minion cards on the board
     * @param lanes lanes of the board
     * @return ArrayNode JSON formatted object containing Minion cards of the board
     */
    public static ArrayNode formatTable(final ArrayList<ArrayList<Minion>> lanes) {
        ArrayNode tableNode = mapper.createArrayNode();
        for (ArrayList<Minion> lane : lanes) {
            tableNode.add(formatLane(lane));
        }
        return tableNode;
    }

    /**
     * JSON formating the coordinates of a card
     * @param coordinates coordinates of a card
     * @return ObjectNode JSON formatted object containing the coordinates of a card
     */
    public static ObjectNode formatCoordinates(final Coordinates coordinates) {
        ObjectNode objectCoordinate = mapper.createObjectNode();
        objectCoordinate.put("x", coordinates.getX());
        objectCoordinate.put("y", coordinates.getY());
        return objectCoordinate;
    }
}

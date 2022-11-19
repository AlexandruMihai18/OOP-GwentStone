package main;

import fileio.ActionsInput;
import main.Actions.*;

import static main.ActionTypeEnum.*;

public final class ActionBuilder {
    private ActionBuilder() {

    }

    /**
     * Converting the input action to a specific subclass
     * @param action provided input action, in JSON format
     * @return action, assigned to it's specific subclass
     */
    public static Action buildAction(final ActionsInput action) {
        return switch (action.getCommand()) {
            case GET_PLAYER_DECK -> new GetPlayerDeck(action);
            case GET_PLAYER_HERO -> new GetPlayerHero(action);
            case GET_PLAYER_TURN -> new GetPlayerTurn(action);
            case GET_CARDS_IN_HAND -> new GetCardsInHand(action);
            case END_PLAYER_TURN -> new EndPlayerTurn(action);
            case PLACE_CARD -> new PlaceCard(action);
            case GET_PLAYER_MANA -> new GetPlayerMana(action);
            case GET_CARDS_ON_TABLE -> new GetCardsOnTable(action);
            case GET_CARD_AT_POSITION -> new GetCardAtPosition(action);
            case GET_ENVIRONMENT_CARDS_IN_HAND -> new GetEnvironmentCardsInHand(action);
            case USE_ENVIRONMENT_CARD -> new UseEnvironmentCard(action);
            case GET_FROZEN_CARDS_ON_TABLE -> new GetFrozenCardsOnTable(action);
            case CARD_USES_ATTACK -> new CardUsesAttack(action);
            case CARD_USES_ABILITY -> new CardUsesAbility(action);
            case USE_ATTACK_HERO -> new UseAttackHero(action);
            case USE_HERO_ABILITY -> new UseHeroAbility(action);
            case GET_TOTAL_GAMES_PLAYED -> new GetTotalGamesPlayed(action);
            case GET_PLAYER_ONE_WINS -> new GetPlayerOneWins(action);
            case GET_PLAYER_TWO_WINS -> new GetPlayerTwoWins(action);
            default -> null;
        };
    }
}

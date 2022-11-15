package main.Actions;

import fileio.ActionsInput;
import fileio.Coordinates;
import main.Board;
import main.Cards.Hero;
import main.Cards.Minion;
import main.Game;

public class Use_Attack_Hero extends Action{
    public Use_Attack_Hero(ActionsInput action) {
        super(action);
    }

    @Override
    public void setOutput(Game game) {
    }

    @Override
    public void setError(String error) {
        getOutput().put("command", getCommand());
        getOutput().put("cardAttacker", formatCoordinates(getCardAttacker()));
        getOutput().put("error", error);
    }

    @Override
    public void action(Board board) {
        Minion minionAttacker = getCardOnBoard(board, getCardAttacker());
        Hero hero = getHero(board);
        if (minionAttacker.isFrozen()) {
            setError("Attacker card is frozen.");
            return;
        }

        if (minionAttacker.isUsed()) {
            setError("Attacker card has already attacked this turn.");
            return;
        }

        if (checkForTank(board)) {
            setError("Attacked card is not of type 'Tank'.");
            return;
        }

        hero.setHealth(-minionAttacker.getAttackDamage());
        minionAttacker.setUsed(true);
    }

    public Hero getHero(Board board) {
        switch (board.getTurn()) {
            case 1:
                return board.getPlayerTwoHero();
            case 2:
                return board.getPlayerOneHero();
        }
        return null;
    }

    public Minion getCardOnBoard(Board board, Coordinates coordinates) {
        switch (coordinates.getX()) {
            case 0:
                return board.getPlayerTwoBackLane().get(coordinates.getY());
            case 1:
                return board.getPlayerTwoFrontLane().get(coordinates.getY());
            case 2:
                return board.getPlayerOneFrontLane().get(coordinates.getY());
            case 3:
                return board.getPlayerOneBackLane().get(coordinates.getY());
            default: return null;
        }
    }

    public boolean isEnemyCard(Board board, Coordinates coordinates) {
        switch (board.getTurn()) {
            case 1:
                if (coordinates.getX() >= 2)
                    return false;
                break;
            case 2:
                if (coordinates.getX() < 2)
                    return false;
                break;
        }
        return true;
    }

    public boolean checkForTank(Board board) {
        switch (board.getTurn()) {
            case 1:
                for (Minion minion : board.getPlayerTwoFrontLane()) {
                    if (minion.isTaunt())
                        return true;
                }
                break;
            case 2:
                for (Minion minion : board.getPlayerOneFrontLane()) {
                    if (minion.isTaunt())
                        return true;
                }
        }
        return false;
    }
}

package main.Actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.Coordinates;
import main.Board;
import main.Cards.Minion;
import main.Game;

public abstract class Action {
    private String command;
    private int handIdx;
    private Coordinates cardAttacker;
    private Coordinates cardAttacked;
    private int affectedRow;
    private int playerIdx;
    private int x;
    private int y;

    private ObjectMapper mapper = new ObjectMapper();
    private ObjectNode output = mapper.createObjectNode();

    public Action(ActionsInput action) {
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();
        this.cardAttacker = action.getCardAttacker();
        this.cardAttacked = action.getCardAttacked();
        this.affectedRow = action.getAffectedRow();
        this.playerIdx = action.getPlayerIdx();
        this.x = action.getX();
        this.y = action.getY();
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public void setCardAttacker(Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    public Coordinates getCardAttacked() {
        return cardAttacked;
    }

    public void setCardAttacked(Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ObjectNode getOutput() {
        return output;
    }

    public abstract void setOutput(Game game);

    public abstract void setError(String error);

    public abstract void action(Board board);

    public void cleanBoard(Board board) {
        board.getPlayerTwoBackLane().removeIf(minion -> minion.getHealth() <= 0);
        board.getPlayerTwoFrontLane().removeIf(minion -> minion.getHealth() <= 0);
        board.getPlayerOneFrontLane().removeIf(minion -> minion.getHealth() <= 0);
        board.getPlayerOneBackLane().removeIf(minion -> minion.getHealth() <= 0);
    }

    public int checkVictory(Board board) {
        if (board.getPlayerOneHero().getHealth() <= 0)
            return 2;
        if (board.getPlayerTwoHero().getHealth() <= 0)
            return 1;
        return 0;
    }
}

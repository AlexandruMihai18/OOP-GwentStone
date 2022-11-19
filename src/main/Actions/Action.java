package main.Actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.Coordinates;
import main.Board;

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

    public Action() {

    }

    public Action(final ActionsInput action) {
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();
        this.cardAttacker = action.getCardAttacker();
        this.cardAttacked = action.getCardAttacked();
        this.affectedRow = action.getAffectedRow();
        this.playerIdx = action.getPlayerIdx();
        this.x = action.getX();
        this.y = action.getY();
    }

    public final String getCommand() {
        return command;
    }

    public final void setCommand(final String command) {
        this.command = command;
    }

    public final int getHandIdx() {
        return handIdx;
    }

    public final void setHandIdx(final int handIdx) {
        this.handIdx = handIdx;
    }

    public final Coordinates getCardAttacker() {
        return cardAttacker;
    }

    public final void setCardAttacker(final Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    public final Coordinates getCardAttacked() {
        return cardAttacked;
    }

    public final void setCardAttacked(final Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }

    public final int getAffectedRow() {
        return affectedRow;
    }

    public final void setAffectedRow(final int affectedRow) {
        this.affectedRow = affectedRow;
    }

    public final int getPlayerIdx() {
        return playerIdx;
    }

    public final void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    public final int getX() {
        return x;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(final int y) {
        this.y = y;
    }

    public final ObjectNode getOutput() {
        return output;
    }

    /**
     * Returning JSON formatted output depending on the type of action
     * @param board given board from which there will be extracted info
     */
    public abstract void setOutput(Board board);

    /**
     * Returning a JSON formatted error depending on the type of action
     * @param error error message
     */
    public abstract void setError(String error);

    /**
     * Implemented action depending of the command given
     * @param board given board which will be modified accordingly
     */
    public abstract void action(Board board);
}

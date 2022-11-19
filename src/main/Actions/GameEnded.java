package main.Actions;

import main.Board;

public final class GameEnded extends Action {
    public GameEnded() {

    }

    @Override
    public void setOutput(final Board board) {
        if (board.getVictory() == 1) {
            getOutput().put("gameEnded", "Player one killed the enemy hero.");
        } else {
            getOutput().put("gameEnded", "Player two killed the enemy hero.");
        }
        board.setVictory(0);
    }

    @Override
    public void setError(final String error) {

    }

    @Override
    public void action(final Board board) {

    }
}

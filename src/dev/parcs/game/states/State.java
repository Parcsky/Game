package dev.parcs.game.states;

import java.awt.*;

public abstract class State {



    public static State currentState = null;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public abstract void render(Graphics g);

    public abstract void update();
}

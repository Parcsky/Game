package dev.parcs.game.handler;

import dev.parcs.game.entities.Creature;

import java.awt.*;
import java.util.ArrayList;


public class CreatureControl implements ControlManager {
    public ArrayList<Creature> creatures = new ArrayList<>();

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
    }

    public void add(Creature creature) {
        creatures.add(creature);
    }

}

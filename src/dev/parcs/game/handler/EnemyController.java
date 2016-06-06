package dev.parcs.game.handler;

import dev.parcs.game.Game;
import dev.parcs.game.entities.Creature;
import dev.parcs.game.entities.Enemy;

import java.awt.*;
import java.util.Iterator;


public class EnemyController extends CreatureControl {

    private Enemy tempEnemy;

    @Override
    public void update() {
        for (Iterator<Creature> iterator = creatures.iterator(); iterator.hasNext(); ) {
            Creature creature = iterator.next();
            tempEnemy = (Enemy) creature;
            tempEnemy.update();
            if (tempEnemy.getY() > Game.height + 100) {
                iterator.remove();
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        for (Creature entity : creatures) {
            tempEnemy = (Enemy) entity;
            tempEnemy.render(graphics);
        }
    }

}

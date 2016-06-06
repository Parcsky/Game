package dev.parcs.game.entities;

import dev.parcs.game.Game;
import dev.parcs.game.handler.BulletController;

import java.awt.*;

public abstract class Creature extends Entity {

    public int health, damage;
    protected boolean isDead;
    protected BulletController bulletController;

    public Creature(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
    }

    public abstract void update();

    public BulletController bullet() {
        return bulletController;
    }


    public abstract void render(Graphics g);

    public abstract boolean isDead();

    public int getHealth() {
        return health;
    }


}

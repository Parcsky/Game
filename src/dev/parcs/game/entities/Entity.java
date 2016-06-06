package dev.parcs.game.entities;

import dev.parcs.game.Game;

import java.awt.*;
import java.util.Random;

public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Game game;
    protected int velocity;
    protected Random random;

    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        random = new Random();
    }

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public float getY() {
        return y;
    }


    public float getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void update();

    public abstract void render(Graphics g);

}

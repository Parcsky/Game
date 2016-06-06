package dev.parcs.game.entities.weapon;

import dev.parcs.game.Game;
import dev.parcs.game.entities.Entity;

import java.awt.*;

/**
 * Created by IanJasper on 5/15/2016.
 */
public class Weapon extends Entity {

    public static float dx, dy;
    protected int damage;
    protected int fireTiming;

    public Weapon(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
    }


    public int getDamage() {
        return damage;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}

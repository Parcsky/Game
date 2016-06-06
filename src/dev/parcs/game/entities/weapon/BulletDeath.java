package dev.parcs.game.entities.weapon;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.Animation;

import java.awt.*;

/**
 * Created by IanJasper on 5/19/2016.
 */
public class BulletDeath extends Weapon {
    private Animation bullet;

    public BulletDeath(Game game, Animation bullet, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        velocity = 10;
        this.bullet = bullet;

    }


    @Override
    public void update() {

        y = y + velocity;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bullet.getFrames(), (int) getX(), (int) getY(), getWidth(), getHeight(), null);
    }
}



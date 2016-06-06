package dev.parcs.game.entities.weapon;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.Animation;

import java.awt.*;


public class Bullet extends Weapon {

    private Animation animation;

    public Bullet(Game game, Animation animation, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        this.animation = animation;
        velocity = 10;
        damage = 10;

    }


    @Override
    public void update() {
        animation.update();
        y = y - velocity;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getFrames(), (int) getX(), (int) getY(), getWidth(), getHeight(), null);
    }
}

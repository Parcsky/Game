package dev.parcs.game.entities;

import dev.parcs.game.graphics.Animation;
import dev.parcs.game.graphics.image.Assets;

import java.awt.*;

public class Explosion extends Entity {

    public Animation explosionAnim;

    public Explosion(float x, float y, int width, int height) {
        super(x, y, width, height);
        explosionAnim = new Animation(Assets.explode, 50, false);
    }

    @Override
    public void update() {
        explosionAnim.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(explosionAnim.getFrames(), (int) x, (int) y, width, height, null);
    }
}

package dev.parcs.game.handler;

import dev.parcs.game.entities.Explosion;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by IanJasper on 5/17/2016.
 */
public class ExplosionControl implements ControlManager {

    ArrayList<Explosion> explosions;
    private Explosion tempExplosion;

    public ExplosionControl() {
        explosions = new ArrayList<>();
    }

    @Override
    public void update() {
        for (Iterator<Explosion> iterator = explosions.iterator(); iterator.hasNext(); ) {
            Explosion explosion = iterator.next();
            tempExplosion = explosion;
            tempExplosion.update();
            if (tempExplosion.explosionAnim.remove) {
                iterator.remove();
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        for (Explosion explosion : explosions) {
            tempExplosion = explosion;
            tempExplosion.render(graphics);
        }
    }

    public void add(Explosion explosion) {
        explosions.add(explosion);
    }

}

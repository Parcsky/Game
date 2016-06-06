package dev.parcs.game.handler;

import dev.parcs.game.Game;
import dev.parcs.game.entities.weapon.Weapon;

import java.awt.*;
import java.util.Iterator;


public class BulletController extends WeaponControl {

    public Weapon weapon;

    public BulletController(Weapon weapon) {
        this.weapon = weapon;
    }


    @Override
    public void update() {
        for (Iterator<Weapon> iterator = weapons.iterator(); iterator.hasNext(); ) {
            Weapon weapon = iterator.next();
            weapon.update();
            if (weapon.getY() < -100 || weapon.getY() > Game.height) {
                iterator.remove();
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        for (Weapon entity : weapons) {
            entity.render(graphics);
        }
    }

    public void addBullet(Weapon weapon) {
        weapons.add(weapon);
    }
}

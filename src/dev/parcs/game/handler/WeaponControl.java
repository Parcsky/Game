package dev.parcs.game.handler;

import dev.parcs.game.entities.weapon.Weapon;

import java.awt.*;
import java.util.ArrayList;


public class WeaponControl implements ControlManager {
    public ArrayList<Weapon> weapons = new ArrayList<>();

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }

    protected void add(Weapon weapon) {
        weapons.add(weapon);
    }

}

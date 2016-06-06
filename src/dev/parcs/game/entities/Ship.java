package dev.parcs.game.entities;

import dev.parcs.game.Game;
import dev.parcs.game.entities.weapon.Bullet;
import dev.parcs.game.entities.weapon.BulletDeath;
import dev.parcs.game.entities.weapon.Weapon;
import dev.parcs.game.graphics.Animation;
import dev.parcs.game.graphics.image.Assets;
import dev.parcs.game.handler.BulletController;
import dev.parcs.game.input.Attack;
import dev.parcs.game.sound.Audio;

import java.awt.*;
import java.awt.image.BufferedImage;

import static dev.parcs.game.entities.weapon.Weapon.dx;
import static dev.parcs.game.entities.weapon.Weapon.dy;


public class Ship extends Creature implements Attack {

    private Animation playerLeft, playerRight;
    private BulletController bulletController;
    private int delayAttack;
    private Animation bulletAnim;

    public Ship(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        velocity = 5;
        health = 100;
        damage = 7;
        playerLeft = new Animation(Assets.playerLeft, 200, false);
        playerRight = new Animation(Assets.playerRight, 100, false);
        bulletController = new BulletController(new Bullet(game, bulletAnim, getX() - getWidth() / 3,
                getY() - 10, getWidth() / 2, getHeight() / 2));
        bulletAnim = new Animation(Assets.bullet, 50, true);
    }

    private void moveShip() {
        dx = 0;
        dy = 0;
        if (game.getKeyManager().isUp() && getY() >= 0) {
            dy = -velocity;
        }
        if (game.getKeyManager().isDown() && getY() <= game.getHeight() - height) {
            dy = velocity;
        }
        if (game.getKeyManager().isLeft() && x >= 0) {
            dx = -velocity;
        }
        if (game.getKeyManager().isRight() && x <= game.getWidth() - width) {
            dx = velocity;
        }

        y += dy;
        x += dx;
    }

    @Override
    public void update() {
        delayAttack++;

        bulletAnim.update();
        playerRight.update();
        playerLeft.update();
        bulletController.update();
        useWeapon();
        shipTurbo();
        moveShip();
    }

    @Override
    public void render(Graphics graphics) {
        bulletController.render(graphics);
        graphics.drawImage(getCurrentFrame(), (int) getX(), (int) getY(), width, height, null);

    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    private BufferedImage getCurrentFrame() {
        if (dx < 0) return playerLeft.getFrames();
        if (dx > 0) return playerRight.getFrames();
        else return Assets.playerIdle;
    }

    public BulletController bullet() {
        return bulletController;
    }

    @Override
    public void useWeapon() {

        if (game.getKeyManager().isSpace() && delayAttack > 10) {
            Audio.gunSound.play();
            bulletController.addBullet(new Bullet(game, bulletAnim, getX() - getWidth() / 3,
                    getY() - 10, getWidth() / 2, getHeight() / 2));

            bulletController.addBullet(new Bullet(game, bulletAnim, getX() + 15,
                    getY() - 10, getWidth() / 2, getHeight() / 2));

            bulletController.addBullet(new Bullet(game, bulletAnim, getX() + 50,
                    getY() - 10, getWidth() / 2, getHeight() / 2));

            delayAttack = 0;
        }
    }

    @Override
    public void changeWeapon(Weapon weapon) {


    }


    public void shipTurbo() {
        bulletController.addBullet(new BulletDeath(game, bulletAnim, getX() - 15,
                getY() + 35, 64, 64));

        bulletController.addBullet(new BulletDeath(game, bulletAnim, getX() + 15,
                getY() + 35, 64, 64));


    }


}

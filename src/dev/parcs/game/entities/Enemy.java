package dev.parcs.game.entities;

import dev.parcs.game.Game;
import dev.parcs.game.entities.weapon.BulletDeath;
import dev.parcs.game.graphics.Animation;
import dev.parcs.game.graphics.image.Assets;
import dev.parcs.game.handler.BulletController;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Enemy extends Creature {
    public int enemyRandom, randomMove;
    private boolean isDown, isUp, isReach;
    private boolean turnRight, turnLeft;
    private Animation falconBullet, hawkBullet, bulletHead;
    private int bulletTime;
    private int ID;


    public Enemy(Game game, int ID, float x, float y, int width, int height) {
        super(game, x, y, width, height);
        this.ID = ID;
        velocity = 3;
        health = 50;
        isDead = false;
        isReach = false;
        System.out.println("Enemy ID: " + enemyRandom);
        randomMove = random.nextInt(400);
        bulletController = new BulletController(null);
        falconBullet = new Animation(Assets.deathRayWep, 100, true);
        hawkBullet = new Animation(Assets.enemyBullet, 200, true);
        bulletHead = new Animation(Assets.bulletHead, 200, true);

    }

    @Override
    public void update() {
        bulletTime++;
        falconBullet.update();
        bulletHead.update();
        moveEnemy(ID);
        enemyAttack(ID, bulletTime);
        bulletController.update();

    }

    @Override
    public void render(Graphics g) {
        bulletController.render(g);
        g.drawImage(getCurrentFrame(), (int) getX(), (int) getY(), width, height, null);
    }

    private BufferedImage getCurrentFrame() {
        if (ID == 1 && game.kills >= 0) return Assets.enemy1;
        if (ID == 2 && game.kills >= 0) return Assets.enemy2;
        if (ID == 3 && game.kills >= 50) return Assets.enemy3;
        else return null;
    }


    @Override
    public boolean isDead() {
        if (health < 0) {
            isDead = true;
        }
        if (health > 0) {
            isDead = false;
        }
        return isDead;
    }

    private void moveEnemy(int ID) {

        switch (ID) {
            case 1:
                setHawkMove();
                break;
            case 2:
                setFalconMove();
                break;
            case 3:
                setBlackMove();
        }

    }

    private void enemyAttack(int ID, int bulletTime) {
        switch (ID) {
            case 1:
                setHawkAttack(bulletTime);
                break;
            case 2:
                setFalconAttack(bulletTime);
                break;
            case 3:
                setBlackAttack();

        }

    }

    private void setBlackAttack() {
        if (bulletTime >= 30) {
            bulletController.addBullet(new BulletDeath(game, bulletHead, getX() + 20, getY() + 40, 54, 54));
            this.bulletTime = 0;
        }
    }

    private void setHawkAttack(int bulletTime) {
        if (bulletTime >= 20) {

            bulletController.addBullet(new BulletDeath(game, hawkBullet, getX() + 20, getY() + 40, 54, 54));
            this.bulletTime = 0;
        }
    }


    private void setHawkMove() {
        if (!isReach || y <= randomMove) {
            y += velocity;
            if (y >= randomMove) isReach = true;
        }
        if (isReach) {
            turnRight = true;
        }
        if (turnRight) {
            x = x + velocity;
            if (x >= game.getWidth() - 100) {
                turnRight = false;
                turnLeft = true;
            }
        }
        if (turnLeft) {
            x = x - velocity - 3;
            if (x <= 100) {
                turnRight = true;
                turnLeft = false;
            }
        }

    }

    private void setFalconMove() {
        y = y + velocity;

    }

    private void setFalconAttack(int bulletTime) {
        if (bulletTime >= 30) {

            bulletController.addBullet(new BulletDeath(game, falconBullet, getX() + 10, getY() + 40, 64, 64));
            this.bulletTime = 0;
        }
    }

    private void setBlackMove() {
        if (!isReach || y <= randomMove) {
            y += velocity;
            if (y >= randomMove) isReach = true;
        }
        if (isReach) {
            turnLeft = true;
        }
        if (turnRight) {
            x = x + velocity;
            if (x >= game.getWidth() - 100) {
                turnRight = false;
                turnLeft = true;
            }
        }
        if (turnLeft) {
            x = x - velocity - 3;
            if (x <= 100) {
                turnRight = true;
                turnLeft = false;
            }
        }

    }
}

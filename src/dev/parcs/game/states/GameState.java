package dev.parcs.game.states;

import dev.parcs.game.Game;
import dev.parcs.game.entities.*;
import dev.parcs.game.entities.weapon.Weapon;
import dev.parcs.game.graphics.hud.GameHud;
import dev.parcs.game.handler.EnemyController;
import dev.parcs.game.handler.ExplosionControl;
import dev.parcs.game.sound.Audio;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;


public class GameState extends State {
    private int delay;
    private Ship ship;
    private GameHud gameHud;
    private Game game;
    private EnemyController enemyControl;
    private ExplosionControl explosionControl;
    private Random random;

    public GameState(Game game) {
        this.game = game;
        game.kills = 0;
        game.score = 0;
        ship = new Ship(game, game.getWidth() / 2 - 32, game.getHeight() - 100, 74, 74);
        gameHud = new GameHud(game, ship);
        enemyControl = new EnemyController();
        explosionControl = new ExplosionControl();
        random = new Random();
        Audio.bgmusic.loop();
        Audio.main.stop();

    }

    @Override
    public void update() {
        if (ship.isDead()) {
            State.setCurrentState(new GameOverState(game));
        }


        enemyControl.update();
        explosionControl.update();
        gameHud.update();
        ship.update();
        delay++;
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        setGameStateBg(graphics);
        enemyControl.render(graphics);
        explosionControl.render(graphics);
        ship.render(graphics);
        spawnEnemy(delay);
        battle(graphics2D);
        gameHud.render(graphics2D);


    }

    private void setGameStateBg(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, game.getWidth(), game.getHeight());
    }

    private void spawnEnemy(int delay) {
        if (delay > 50) {
            if (game.kills >= 0)
                enemyControl.add(new Enemy(game, 1, random.nextInt(game.getWidth() - 100), -50, 80, 80));
            if (game.kills >= 20)
                enemyControl.add(new Enemy(game, 2, random.nextInt(game.getWidth() - 100), -50, 80, 80));
            if (game.kills > 100)
                enemyControl.add(new Enemy(game, 3, random.nextInt(game.getWidth() - 100), -50, 80, 80));
            this.delay = 0;
        }
    }

    private void battle(Graphics2D g2D) {

        Iterator<Creature> iterator = enemyControl.creatures.iterator();
        while (iterator.hasNext()) {
            Creature enemy = iterator.next();
            if (ship.getBounds().intersects(enemy.getBounds())) {
                Audio.shipImpact.play();
                ship.health = ship.getHealth() - 5;
                iterator.remove();
                explosionControl.add(new Explosion(enemy.getX() + 20, enemy.getY() + 30, 50, 50));
            }

            for (Iterator<Weapon> bulletItr = ship.bullet().weapons.iterator(); bulletItr.hasNext(); ) {
                Entity bullet = bulletItr.next();

                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    Audio.enemyImpact.play();
                    game.score = game.getScore() + 10;
                    bulletItr.remove();
                    enemy.health = enemy.getHealth() - ship.damage;
                    explosionControl.add(new Explosion(enemy.getX() + 20, enemy.getY() + 30, 50, 50));

                }
            }

            for (Iterator<Weapon> bulletItr = enemy.bullet().weapons.iterator(); bulletItr.hasNext(); ) {
                Entity bullet = bulletItr.next();

                if (bullet.getBounds().intersects(ship.getBounds())) {
                    Audio.shipImpact.play();
                    ship.health = ship.getHealth() - 5;
                    explosionControl.add(new Explosion(ship.getX() + 20, ship.getY() - 30, 50, 50));
                    bulletItr.remove();
                }


            }
            if (enemy.isDead()) {
                explosionControl.add(new Explosion(enemy.getX() - 10, enemy.getY(), 120, 120));
                Audio.enemyImpact.play();
                game.kills = game.getKills() + 1;
                iterator.remove();
            }


        }

    }
}

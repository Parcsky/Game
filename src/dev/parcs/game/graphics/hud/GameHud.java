package dev.parcs.game.graphics.hud;

import dev.parcs.game.Game;
import dev.parcs.game.entities.Ship;

import java.awt.*;


public class GameHud extends Hud {
    private Ship ship;


    public GameHud(Game game, Ship ship) {
        super(game);
        this.ship = ship;
        font = new Font("Press start", Font.BOLD, 12);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D graphics) {
        super.render(graphics);
        graphics.setFont(font);
        graphics.setColor(new Color(40, 40, 40));

        graphics.setColor(Color.WHITE);
        graphics.drawString("Ian Parcs", game.getWidth() - 100, game.getHeight() - 10);
        graphics.drawString("Score: " + game.getScore(), game.getWidth() - 160, 40);
        graphics.drawString("Health:" + ship.getHealth(), 30, 40);
        graphics.drawString("Kills: " + game.getKills(), 180, 40);
        graphics.drawString("X: " + ship.getX(), 30, 70);
        graphics.drawString("Y: " + ship.getY(), 30, 90);
        graphics.setFont(font);
    }

}







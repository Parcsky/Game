package dev.parcs.game.graphics.hud;

import dev.parcs.game.Game;
import dev.parcs.game.states.GameState;
import dev.parcs.game.states.State;

import java.awt.*;

public class MenuHud extends Hud {
    public static Rectangle playButton = new Rectangle(Game.width / 2 - 100, 300, 200, 50);
    private Rectangle title = new Rectangle(game.getWidth() / 2 - 250, 50, 500, 200);
    private Rectangle optionButton = new Rectangle(game.getWidth() / 2 - 100, 370, 200, 50);
    private Rectangle quitButton = new Rectangle(game.getWidth() / 2 - 100, 440, 200, 50);
    private Font fontMenu = new Font("Press start", Font.BOLD, 16);

    public MenuHud(Game game) {
        super(game);

        font = new Font("Press start", Font.BOLD, 30);
    }


    @Override
    public void update() {

    }

    private void mouseEvent(Graphics2D graphics) {
        if (game.getMouseManager().isClick) {
            graphics.setColor(Color.darkGray);
            graphics.fillRect(Game.width / 2 - 100, 300, 200, 50);
            State.setCurrentState(new GameState(game));
        }
    }

    @Override
    public void render(Graphics2D graphics) {
        setBackground(graphics);
        graphics.setColor(Color.white);
        setMenuTitle(graphics, "SPACE MATRIX");
        // graphics.drawString("THANKS FOR WATCHING!",game.getWidth()/ 2 - 300,game.getHeight()/ 2 + 250);
        mouseEvent(graphics);
        addRectangle(graphics);
        setOption(graphics);
        graphics.drawString("Ian Parcs", game.getWidth() - 150, game.getHeight() - 10);
        setMovingMatrix(graphics);


    }

    private void setMenuTitle(Graphics graphics, String title) {
        graphics.setFont(font);
        graphics.drawString(title, game.getWidth() / 2 - 200, 150);
    }

    private void setOption(Graphics graphics) {
        graphics.setFont(fontMenu);
        graphics.setColor(Color.white);
        graphics.drawString("Play", game.getWidth() / 2 - 30, 335);
        graphics.drawString("Option", game.getWidth() / 2 - 50, 400);
        graphics.drawString("Quit", game.getWidth() / 2 - 30, 470);


    }

    private void addRectangle(Graphics2D graphics) {
        graphics.draw(title);
        graphics.draw(playButton);
        graphics.draw(optionButton);
        graphics.draw(quitButton);
    }

    private void setBackground(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, game.getWidth(), game.getHeight());
    }
}

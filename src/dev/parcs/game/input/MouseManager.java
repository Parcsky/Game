package dev.parcs.game.input;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.hud.MenuHud;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by IanJasper on 5/19/2016.
 */
public class MouseManager implements MouseListener {

    public boolean isClick, isRelease;
    public int mouseX, mouseY;
    private Game game;

    public MouseManager(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //   private Rectangle playButton = new Rectangle(game.getWidth() / 2 - 100, 300, 200, 50);
        //  private Rectangle optionButton = new Rectangle(game.getWidth() / 2 - 100, 370, 200, 50);
        //  private Rectangle quitButton = new Rectangle(game.getWidth() / 2 - 100, 440, 200, 50);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if ((mouseX >= MenuHud.playButton.getMinX() && mouseX <= MenuHud.playButton.getMaxX())
                && (mouseY >= MenuHud.playButton.getMinY() && mouseY <= MenuHud.playButton.getMaxY())) {
            isClick = true;


        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isClick = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

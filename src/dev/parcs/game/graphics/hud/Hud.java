package dev.parcs.game.graphics.hud;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.Matrix;

import java.awt.*;


public abstract class Hud {
    private static Hud currentHud = null;
    protected int x, y;
    protected Font font;

    protected Game game;
    private GraphicsEnvironment graphicsEnvironment;
    private Matrix[] matrix;
    private AlphaComposite alphaComposite;
    private Composite composite;

    public Hud(Game game) {
        this.game = game;
        graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsEnvironment.getAvailableFontFamilyNames();

        matrix = new Matrix[game.getWidth()];

        for (int i = 0; i < matrix.length; i++) {
            x = i * 10;
            matrix[i] = new Matrix(x);
        }
    }


    public static Hud getCurrentHud() {
        return currentHud;
    }

    public static void setCurrentHud(Hud currentHud) {
        Hud.currentHud = currentHud;
    }

    public void render(Graphics2D graphics2D) {

        setMovingMatrix(graphics2D);
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    }


    public abstract void update();

    public void setMovingMatrix(Graphics2D graphics) {
        for (Matrix aMatrix : matrix) {
            if (aMatrix.y > game.getHeight() + aMatrix.chars.length) {
                aMatrix.y = -game.getHeight();
            }
            aMatrix.renders(graphics);
        }
    }
}




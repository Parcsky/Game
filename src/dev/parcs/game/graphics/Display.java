package dev.parcs.game.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IanJasper on 5/12/2016.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;
    private Dimension dimension;

    public Display(String title, int width, int height) {
        frame = new JFrame();
        canvas = new Canvas();
        dimension = new Dimension();
        createDisplay(title, width, height);
    }

    private void createDisplay(String title, int width, int height) {
        frame.setTitle(title);
        setFrameSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(canvas);
        frame.pack();
    }

    private void setFrameSize(int width, int height) {
        frame.setResizable(false);
        frame.setSize(width, height);
        dimension.setSize(width, height);
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setFocusable(false);

    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}

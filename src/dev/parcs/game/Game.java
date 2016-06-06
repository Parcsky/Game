package dev.parcs.game;


import dev.parcs.game.graphics.Display;
import dev.parcs.game.graphics.image.Assets;
import dev.parcs.game.input.KeyManager;
import dev.parcs.game.input.MouseManager;
import dev.parcs.game.states.GameState;
import dev.parcs.game.states.MenuState;
import dev.parcs.game.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {

    public static int width = 720, height = 620;
    public int kills, score;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private Display display;
    private GameState gameState;
    private MenuState menuState;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private boolean running;

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    private void init() {

        mouseManager = new MouseManager(this);
        keyManager = new KeyManager();
        display = new Display("Space Matrix", width, height);
        display.getFrame().requestFocus();
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);

        Assets.load();
        menuState = new MenuState(this);
        State.setCurrentState(menuState);


    }

    protected void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Draw Here

        if (State.getCurrentState() != null) {
            State.getCurrentState().render(graphics2D);
        }

        // Draw End
        bufferStrategy.show();
        graphics.dispose();
    }

    private void update() {

        if (keyManager.isEsc()) {
            State.setCurrentState(menuState);
        }
        if (keyManager.isEnter()) {
            State.setCurrentState(gameState);
        }

        if (State.getCurrentState() != null) {
            State.getCurrentState().update();

        }
    }

    @Override
    public void run() {
        init();
        double nanoSecond = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long current = System.nanoTime();
            delta += (current - lastTime) / nanoSecond;
            lastTime = current;

            if (delta >= 1) {
                update();
                render();
                delta--;

            }
        }
        stop();
    }

    synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();


    }

    private synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getKills() {
        return kills;
    }

    public int getScore() {
        return score;
    }
}
package dev.parcs.game.input;

import dev.parcs.game.sound.Audio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean up, left, right, down;
    private boolean space, esc, enter;

    public boolean isEsc() {
        return esc;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean isEnter() {
        return enter;
    }

    public boolean isSpace() {
        return space;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("AW");
                up = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_SPACE:
                space = true;

                break;
            case KeyEvent.VK_ESCAPE:
                esc = true;
                Audio.gameover.stop();
                Audio.main.play();
                break;
            case KeyEvent.VK_ENTER:
                enter = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_SPACE:
                space = false;
                break;
            case KeyEvent.VK_ESCAPE:
                esc = false;

                break;
            case KeyEvent.VK_ENTER:
                enter = false;
                break;
        }

    }


}

package dev.parcs.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by IanJasper on 5/13/2016.
 */
public class Animation {

    public boolean remove;
    private BufferedImage[] frames;
    private int frameSpeed, index;
    private long lastTime, timer;
    private boolean isLoop;
    private boolean loopAnim;


    public Animation(BufferedImage[] frames, int frameSpeed, boolean isLoop) {
        this.frames = frames;
        this.isLoop = isLoop;
        this.frameSpeed = frameSpeed;
        lastTime = System.currentTimeMillis();
        index = 0;
        loopAnim = true;
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        while (loopAnim && timer > frameSpeed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
                if (!isLoop) {
                    loopAnim = false;
                    remove = true;
                }
            }
        }
    }

    public BufferedImage getFrames() {
        return frames[index];
    }

}

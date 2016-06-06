package dev.parcs.game.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

    public static final Audio gunSound = new Audio("/laser.wav");
    public static final Audio enemyImpact = new Audio("/shipExplode.wav");
    public static final Audio shipImpact = new Audio("/explosion.aiff");
    public static final Audio bgmusic = new Audio("/mortal-kombat.wav");
    public static final Audio gameover = new Audio("/gameover.wav");
    public static final Audio main = new Audio("/main.wav");
    public static final Audio contra = new Audio("/contra.wav");
    private AudioClip clip;

    public Audio(String filename) {
        try {
            clip = Applet.newAudioClip(Audio.class.getResource(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            new Thread() {
                public void run() {
                    clip.play();
                }

            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        try {
            new Thread() {
                public void run() {
                    clip.loop();
                }

            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

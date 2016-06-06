package dev.parcs.game.states;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.image.ImageLoader;
import dev.parcs.game.graphics.image.SpriteSheet;
import dev.parcs.game.sound.Audio;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameOverState extends State {

    SpriteSheet bgSheet = new SpriteSheet(ImageLoader.load("/sprite/background.png"));
    Game game;
    private BufferedImage bg;
    private ArrayList<Integer> scoreList = new ArrayList<>();
    private Font font = new Font("Press start", Font.PLAIN, 12);

    public GameOverState(Game game) {
        this.game = game;
        bg = bgSheet.crop(0, 0, 718, 479);
        Audio.gameover.play();
        Audio.bgmusic.stop();
        scoreList.add(game.score);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg, 0, 0, game.getWidth(), game.getHeight(), null);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("High score", 50, 50);
        g.drawString(scoreList.get(0) + " ", 50, 70);
    }


    @Override
    public void update() {

    }
}

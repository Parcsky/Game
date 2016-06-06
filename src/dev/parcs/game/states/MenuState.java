package dev.parcs.game.states;

import dev.parcs.game.Game;
import dev.parcs.game.graphics.hud.MenuHud;
import dev.parcs.game.sound.Audio;

import java.awt.*;

public class MenuState extends State {

    private MenuHud menuHud;

    public MenuState(Game game) {
        Audio.main.play();
        menuHud = new MenuHud(game);

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        menuHud.render((Graphics2D) graphics);
    }


}

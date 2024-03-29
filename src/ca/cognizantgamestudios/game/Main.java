package ca.cognizantgamestudios.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static final String GAME_NAME = "Minimal Win";
    public static void main(String[] args){
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = GAME_NAME;
        cfg.useGL20 = true;
        cfg.width = 1024;
        cfg.height = 768;
        new LwjglApplication(new MinimalWin(), cfg);
    }

}

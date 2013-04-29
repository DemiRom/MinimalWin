package ca.cognizantgamestudios.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHandler {
    public static Sprite playerSprite;

    public static Texture player;
    public static Texture level1;
    public static Texture world;
    public static Texture flag;
    public static Texture enemy;

    public static Sound dead;
    public static Sound win;

    public static Music music;

    public static void loadImages(){

        player = new Texture(Gdx.files.internal("res/images/player.png"));
        playerSprite = new Sprite(player);

        level1 = new Texture(Gdx.files.internal("res/images/level1.png"));

//        world = new Texture(Gdx.files.internal("res/images/world.png"));
//        flag = new Texture(Gdx.files.internal("res/images/flag.png"));
//        enemy = new Texture(Gdx.files.internal("res/images/enemy.png"));
    }
    public static void loadSounds(){
//        dead = Gdx.audio.newSound(Gdx.files.internal("res/sounds/dead.wav"));
//        win = Gdx.audio.newSound(Gdx.files.internal("res/sounds/win.wav"));
    }
    public static void loadMusic(){
//        music = Gdx.audio.newMusic(Gdx.files.internal("res/music/music.mp3"));
    }
}

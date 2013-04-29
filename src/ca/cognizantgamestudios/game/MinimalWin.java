package ca.cognizantgamestudios.game;

import box2dLight.PointLight;
import box2dLight.RayHandler;

import ca.cognizantgamestudios.assets.AssetHandler;

import ca.cognizantgamestudios.collision.CollisionListener;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import org.lwjgl.openal.AL;

public class MinimalWin implements ApplicationListener {
    OrthographicCamera camera;
    SpriteBatch sprite;
    Box2DDebugRenderer renderer;
    World world;

    //lights
    RayHandler ray;
    PointLight playerLight;

    //player
    Body playerBody;
    BodyDef playerDef;
    FixtureDef playerFixture;
    PolygonShape playerShape;

    //world Collision 1
    Body worldBody;
    BodyDef worldDef;
    FixtureDef worldFixture;
    PolygonShape worldShape;
    //world Collision 2
    Body worldBody1;
    BodyDef worldDef1;
    FixtureDef worldFixture1;
    PolygonShape worldShape1;
    //world Collision 3
    Body worldBody2;
    BodyDef worldDef2;
    FixtureDef worldFixture2;
    PolygonShape worldShape2;
    //world Collision 4
    Body worldBody3;
    BodyDef worldDef3;
    FixtureDef worldFixture3;
    PolygonShape worldShape3;
    //world Collision 4
    Body worldBody4;
    BodyDef worldDef4;
    FixtureDef worldFixture4;
    PolygonShape worldShape4;
    //world Collision 5
    Body worldBody5;
    BodyDef worldDef5;
    FixtureDef worldFixture5;
    PolygonShape worldShape5;

    //jumping
    boolean jumped;
    boolean floating;

    int playerPosX, playerPosY;
    int worldPosX, worldPosY;
    @Override
    public void create() {
        playerPosX = 130;
        playerPosY = 170;
        worldPosX = 0;
        worldPosY = 0;

        AssetHandler.loadImages();

        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024, 768);
        sprite = new SpriteBatch();
        world = new World(new Vector2(0, -100), false);

        playerDef = new BodyDef();
        playerDef.type = BodyType.DynamicBody;
        playerDef.position.set(playerPosX, playerPosY);

        playerBody = world.createBody(playerDef);

        playerShape = new PolygonShape();
        playerShape.setAsBox(16, 16);

        playerFixture = new FixtureDef();
        playerFixture.shape = playerShape;
        playerFixture.density = 0.4f;
        playerFixture.friction = 0.4f;
        playerFixture.restitution = 0.1f;

        playerBody.createFixture(playerFixture);

        //World Collision Box #1
        worldDef = new BodyDef();
        worldDef.type = BodyType.StaticBody;
        worldDef.position.set(0,0);
        worldBody  = world.createBody(worldDef);
        worldShape = new PolygonShape();
        worldShape.setAsBox(722, 158);
        worldFixture = new FixtureDef();
        worldFixture.shape = worldShape;
        worldFixture.density = 0.4f;
        worldFixture.friction = 0.7f;
        worldFixture.restitution = 0;
        worldBody.createFixture(worldFixture);

        //World Collision Box #2;
        worldDef1 = new BodyDef();
        worldDef1.type = BodyType.StaticBody;
        worldDef1.position.set(762, 186);
        worldBody1  = world.createBody(worldDef1);
        worldShape1 = new PolygonShape();
        worldShape1.setAsBox(37, 10);
        worldFixture1 = new FixtureDef();
        worldFixture1.shape = worldShape1;
        worldFixture1.density = 0.4f;
        worldFixture1.friction = 0.7f;
        worldFixture1.restitution = 0;
        worldBody1.createFixture(worldFixture1);

        //World Collision Box #3
        worldDef2 = new BodyDef();
        worldDef2.type = BodyType.StaticBody;
        worldDef2.position.set(868, 228);
        worldBody2  = world.createBody(worldDef2);
        worldShape2 = new PolygonShape();
        worldShape2.setAsBox(55, 18);
        worldFixture2 = new FixtureDef();
        worldFixture2.shape = worldShape2;
        worldFixture2.density = 0.4f;
        worldFixture2.friction = 0.7f;
        worldFixture2.restitution = 0;
        worldBody2.createFixture(worldFixture2);

        //World Collision Box #4
        worldDef3 = new BodyDef();
        worldDef3.type = BodyType.StaticBody;
        worldDef3.position.set(1978, 0);
        worldBody3  = world.createBody(worldDef3);
        worldShape3 = new PolygonShape();
        worldShape3.setAsBox(1024, 32);
        worldFixture3 = new FixtureDef();
        worldFixture3.shape = worldShape3;
        worldFixture3.density = 0.4f;
        worldFixture3.friction = 0.7f;
        worldFixture3.restitution = 0;
        worldBody3.createFixture(worldFixture3);

        //World Collision Box #5
        worldDef4 = new BodyDef();
        worldDef4.type = BodyType.StaticBody;
        worldDef4.position.set(2090, 32);
        worldBody4  = world.createBody(worldDef4);
        worldShape4 = new PolygonShape();
        worldShape4.setAsBox(1024, 32);
        worldFixture4 = new FixtureDef();
        worldFixture4.shape = worldShape4;
        worldFixture4.density = 0.4f;
        worldFixture4.friction = 0.7f;
        worldFixture4.restitution = 0;
        worldBody4.createFixture(worldFixture4);

        //World Collision Box #6
        worldDef5 = new BodyDef();
        worldDef5.type = BodyType.StaticBody;
        worldDef5.position.set(2155, 64);
        worldBody5  = world.createBody(worldDef5);
        worldShape5 = new PolygonShape();
        worldShape5.setAsBox(1024, 45);
        worldFixture5 = new FixtureDef();
        worldFixture5.shape = worldShape5;
        worldFixture5.density = 0.4f;
        worldFixture5.friction = 0.7f;
        worldFixture5.restitution = 0;
        worldBody5.createFixture(worldFixture5);

        ray = new RayHandler(world);
        ray.setCombinedMatrix(camera.combined);
        ray.setShadows(true);

        playerLight = new PointLight(ray, 10000, new Color(0,0,1,1), 500,100,100);
        world.setContactListener(new CollisionListener());

    }

    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        camera.update();
        sprite.setProjectionMatrix(camera.combined);

        sprite.begin();
            sprite.draw(AssetHandler.level1, worldPosX, worldPosY);
            AssetHandler.playerSprite.draw(sprite);
            AssetHandler.playerSprite.setPosition(playerPosX-16, playerPosY-16);
        sprite.end();

        //renderer.render(world, camera.combined);

        playerLight.setPosition(playerPosX, playerPosY);

        ray.updateAndRender();
        world.step(1 / 60f, 6, 2);

        tick();
    }
    public void tick(){
        playerPosX = (int)playerBody.getPosition().x;
        playerPosY = (int)playerBody.getPosition().y;

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && !jumped && !floating){
            playerBody.setLinearVelocity(playerBody.getLinearVelocity().x*8, 1200f);
            jumped = true;
            floating = true;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(!Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            jumped = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            playerBody.setLinearVelocity(500f+playerBody.getLinearVelocity().x, world.getGravity().y/2);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            playerBody.setLinearVelocity(-500f-playerBody.getLinearVelocity().x, world.getGravity().y/2);
        }
        if(CollisionListener.isContact){
            floating = false;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            AL.destroy();
            System.exit(1);
        }
        if(playerPosX > 800 && playerPosX < 1500 && worldPosX > -1470){
            moveRight();
        }
        if(playerPosX > 0 && playerPosX < 200 && worldPosX < 0){
            moveLeft();
        }
        if(playerPosY < -32){
            //playerdies
            System.exit(1);
        }
    }
    public void moveRight(){
        //transform all the stuff!
        worldBody.setTransform(worldBody.getPosition().x-5, worldBody.getPosition().y, 0);
        worldBody1.setTransform(worldBody1.getPosition().x-5, worldBody1.getPosition().y, 0);
        worldBody2.setTransform(worldBody2.getPosition().x-5, worldBody2.getPosition().y, 0);
        worldBody3.setTransform(worldBody3.getPosition().x-5, worldBody3.getPosition().y, 0);
        worldBody4.setTransform(worldBody4.getPosition().x-5, worldBody4.getPosition().y, 0);
        worldBody5.setTransform(worldBody5.getPosition().x-5, worldBody5.getPosition().y, 0);
        worldPosX = worldPosX-5;
        playerBody.setTransform(playerPosX-1, playerPosY, 0);
    }
    public void moveLeft(){
        worldBody.setTransform(worldBody.getPosition().x+5, worldBody.getPosition().y, 0);
        worldBody1.setTransform(worldBody1.getPosition().x+5, worldBody1.getPosition().y, 0);
        worldBody2.setTransform(worldBody2.getPosition().x+5, worldBody2.getPosition().y, 0);
        worldBody3.setTransform(worldBody3.getPosition().x+5, worldBody3.getPosition().y, 0);
        worldBody4.setTransform(worldBody4.getPosition().x+5, worldBody4.getPosition().y, 0);
        worldBody5.setTransform(worldBody5.getPosition().x+5, worldBody5.getPosition().y, 0);
        worldPosX = worldPosX+5;
        playerBody.setTransform(playerPosX+1, playerPosY, 0);
    }
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        ray.dispose();
    }
}

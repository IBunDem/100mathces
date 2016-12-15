package com.bundem.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.bundem.GUI.MyButton;
import com.bundem.game.MyGame;

/**
 * Created by Brotherhood on 14.12.2016.
 */
public class Menu implements Screen, InputProcessor
{

    private SpriteBatch batch;
    private Texture txrBg, txrBtn;
    private Sprite sptBg;
    private MyButton btn;
    private OrthographicCamera camera;
    private int btnWidth, btnHeight;

    private MyGame game;

    public Menu(MyGame game){
        this.game=game;
    }

    @Override
    public void show() {
        System.out.println("show Menu");
        Gdx.input.setInputProcessor(this);
        camera = new OrthographicCamera(800, 600);
        camera.position.set(new Vector3(400, 300, 0));
        batch = new SpriteBatch();
        txrBg = new Texture(Gdx.files.internal("bg.jpg"),true);
        sptBg = new Sprite(txrBg);
        txrBtn = new Texture(Gdx.files.internal("btn.png"), true);
        sptBg.setBounds(0,0, 800, 600);
        btnWidth=150; btnHeight=150;
        btn = new MyButton(txrBtn, 100, 100, btnWidth, btnHeight);
    }

    @Override
    public void render(float delta) {
        //System.out.println("render Menu");
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sptBg.draw(batch);
        btn.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        System.out.println("dispose Menu");
        txrBg.dispose();
        txrBtn.dispose();
        btn.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //clickX = screenX;
        //clickY = screenY + btnHeight+(600-2*(screenY+btnHeight));
        if(btn.isPressed(screenX, Gdx.graphics.getHeight() - screenY)){
            dispose();
            game.setScreen(new GameScreen(game));
            System.out.println("pressed, coordinate X: "+screenX+" , Y: "+screenY);
        }
        else
            System.out.println("notPressed, X: "+screenX+" , Y: "+screenY);
        System.out.println("screenX: "+screenX+ " , Y: "+(Gdx.graphics.getWidth() - screenX));
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

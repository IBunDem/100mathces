package com.bundem.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.bundem.TextListener.MyTextInputListener;
import com.bundem.game.MyGame;

/**
 * Created by Brotherhood on 14.12.2016.
 */
public class GameScreen implements Screen, InputProcessor
{
    private SpriteBatch batch;
    private Texture txrSp,txrBg;
    private Sprite sptBg, sptSp;
    private BitmapFont CountFont, StepFont;
    private OrthographicCamera camera;
    private MyTextInputListener inputListener;
    private int countMathces, pl;
    private boolean firstPl;

    private MyGame game;

    public GameScreen(MyGame game){
        this.game=game;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(800, 600);
        camera.position.set(new Vector3(400, 300, 0));
        batch = new SpriteBatch();
        txrBg = new Texture(Gdx.files.internal("bg.jpg"),true);
        sptBg = new Sprite(txrBg);
        sptBg.setBounds(0,0, 800, 600);
        txrSp = new Texture(Gdx.files.internal("spa.jpg"),true);
        sptSp = new Sprite(txrSp);
        sptSp.setBounds(150, 550, 180, 20);
        sptSp.setRotation(10);
        CountFont = new BitmapFont();
        CountFont.setColor(Color.BLUE);
        CountFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        CountFont.getData().setScale(3);
        StepFont = new BitmapFont();
        StepFont.setColor(Color.GREEN);
        StepFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        StepFont.getData().setScale(2);
        inputListener = new MyTextInputListener();
        firstPl = true;
        inputListener.setPl(firstPl);
        countMathces =100;
        pl=1;
        inputListener.setMatches(countMathces);

    }

    @Override
    public void render(float delta) {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sptBg.draw(batch);
        sptSp.draw(batch);
        CountFont.draw(batch, "Count: " + countMathces, 350, 550);
        if(!inputListener.isFlag())	StepFont.draw(batch, "Step of player: " + pl, 300, 50);
        else	StepFont.draw(batch, "Win player: " + pl, 300, 50);
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
        txrBg.dispose();
        txrSp.dispose();
    }

    private void newGame(){
        countMathces=100;
        inputListener.setMatches(countMathces);
        firstPl=true;
        inputListener.setFlag(false);
    }

    private void update(){
        if(Gdx.input.justTouched()&&inputListener.isFlag()){
            newGame();
        }
        if(Gdx.input.justTouched()&&!inputListener.isFlag()){
            Gdx.input.getTextInput(inputListener, "count", "", "take away matches");
            firstPl=!firstPl;
        }
        countMathces=inputListener.getMatches();
        firstPl = inputListener.isPl();
        if(firstPl){
            pl=1;
            StepFont.setColor(Color.GREEN);
        }
        else{
            pl=2;
            StepFont.setColor(Color.RED);
        }
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

package com.bundem.GUI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Brotherhood on 14.12.2016.
 */
public class MyButton {

    //private Rectangle rec = new Rectangle();
    private int width, height, x, y;
    private Texture txrUp, txrDown;
    private Sprite spt;
    private boolean anim;

    public MyButton(Texture txr, int x, int y, int width, int height) {
        this.txrUp = txr;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        spt = new Sprite(txrUp);
        spt.setBounds(this.x, this.y, this.width, this.height);
        anim=false;
    }

    public void setAnim(Texture txr){
        this.txrDown = txr;
        anim=true;
    }

    public boolean isPressed(int x, int y){
        if((x >= this.x && x <= this.x + this.width)&&
                (y >= this.y && y <= this.y + this.height)){
            return true;
        }
            else
                return false;
    }

    public void update(boolean pressed){//Call the method only if is animation(the second texture for press)
        if(pressed){
            spt.setTexture(txrDown);
        }
        else{
            spt.setTexture(txrUp);
        }
    }

    public void draw(SpriteBatch batch){
        spt.draw(batch);
    }

    public void dispose(){
        txrUp.dispose();
        //txrDown.dispose();
    }
}

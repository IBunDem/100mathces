package com.bundem.TextListener;

import com.badlogic.gdx.Input;

/**
 * Created by Brotherhood on 12.12.2016.
 */
public class MyTextInputListener implements Input.TextInputListener {

    private int num;
    private int matches;
    private boolean flag=false, pl;

    @Override
    public void input(String text) {
        num=Integer.parseInt(text);
        if(num<0){
            num*=-1;
        }
        else if(num > 10){
            num=10;
        }
        matches-=num;
        if(matches<=0){
            matches=0;
            flag=true;
        }
        else pl=!pl;
    }

    @Override
    public void canceled() {
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int mathces){
        this.matches=mathces;
    }

    public boolean isFlag() {
        return flag;
    }

    public boolean isPl() {
        return pl;
    }

    public void setPl(boolean pl){
        this.pl = pl;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}

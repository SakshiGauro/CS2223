package com.doubleTrouble;

public class Board {
    int green;
    int yellow;
    int orange;

    public Board (int green, int yellow, int orange){
        this.green = green;
        this.yellow = yellow;
        this.orange = orange;
    }

    public int getGreen(){
        return green;
    }

    public int getYellow(){
        return yellow;
    }

    public int getOrange(){
        return orange;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public void setYellow(int yellow){
        this.yellow = yellow;
    }

    public void setOrange(int orange){
        this.orange = orange;
    }
}

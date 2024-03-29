package com.heatfeet;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Instance {
    Sprite sprite;
    float x, y, width, height;

    public Instance(int x, int y) {
        this.x = x;
        this.y = y;
    }
    abstract void move();

    abstract void update();

    void draw(SpriteBatch batch) {
        this.sprite.setPosition(x-this.sprite.getWidth()/2,y-this.sprite.getHeight()/2);
        this.sprite.draw(batch);
    }



}

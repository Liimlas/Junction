package com.heatfeet;

/**
 * Created by alqio on 25.11.2017.
 */
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    float x, y;

    Sprite sprite;
    Accelometer meter;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = new Sprite(new Texture("player.png"));
        meter = new Accelometer();
    }

    void move() {

        meter.update();

        x += meter.ax;
        y += meter.ay;
    }

    void draw(SpriteBatch batch) {
        this.sprite.setPosition(x,y);
        this.sprite.draw(batch);
    }

}

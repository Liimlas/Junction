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
    }

    void move() {

    }
    void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }

}

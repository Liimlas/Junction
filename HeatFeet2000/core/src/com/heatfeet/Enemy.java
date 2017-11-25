package com.heatfeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;


/**
 * Created by sofiakimpimaki on 25.11.2017.
 */

public class Enemy extends Instance {
    private float speedX, speedY;
    int width, height;

    public Enemy(int x, int y, float speedx, float speedy) {
        super(x, y);
        width = 100;
        height = 100;
        this.speedX = speedx;
        this.speedY = speedy;
        this.sprite = new Sprite(new Texture("enemy.png"));
        sprite.setSize(100,100);
    }

    void update() {
        this.move();

    }
    void move() {
        this.move(this.x < this.width/2 || this.x + this.width/2 > Gdx.graphics.getWidth() , this.y < this.height/2 || this.y + this.height/2 > Gdx.graphics.getHeight());
    }
    void move(Boolean vertical, Boolean horizontal) {

        //jo on vaakasuunnassa seinä
        if (horizontal) {
            speedY = (-1) * speedY;

        } else if(vertical) {
            speedX = (-1)* speedX;
        }
        this.x += speedX;
        this.y += speedY;

    }
}

package com.heatfeet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;


/**
 * Created by sofiakimpimaki on 25.11.2017.
 */

public class Enemy {
    float x, y;
    float speedX, speedY;
    Sprite sprite;
    //Player player = new Player();

    public Enemy(int x, int y, int speed, int speedy) {
        this.x = x;
        this.y = y;
        this.speedX = speed;
        this.speedY = speedy;

        this.sprite = new Sprite(new Texture("enemy.png"));
    }
    void move() {
        Random rn = new Random();
        int answer = rn.nextInt(3);

        if(answer == 0)this.x += speedX;
        else if(answer == 1) this.x -= speedX;
        else if(answer == 2) this.y += speedY;
        else if(answer == 3) this.y -= speedY;


    }
    void draw(SpriteBatch batch) {
        this.sprite.draw(batch);
    }

}

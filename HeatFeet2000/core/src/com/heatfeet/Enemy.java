package com.heatfeet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;


/**
 * Created by sofiakimpimaki on 25.11.2017.
 */

public class Enemy extends Instance {
    private float speedx, speedy;

    public Enemy(int x, int y) {
        super(x, y);
        this.sprite = new Sprite(new Texture("enemy.png"));
    }

    void update() {

    }

    void move() {
        Random rn = new Random();
        int answer = rn.nextInt(3);
        if(answer == 0)this.x += speedx;
        else if(answer == 1) this.x -= speedy;
        else if(answer == 2) this.y += speedx;
        else if(answer == 3) this.y -= speedy;
    }
}

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
    int width, height, enemySize;
    private float hp = 5;
    boolean spawned = true, dying = false;

    public Enemy(int x, int y, float speedx, float speedy) {
        super(x, y);
        Random rn = new Random();
        enemySize = rn.nextInt(70) +40;
        width = enemySize;
        height = enemySize;
        this.speedX = speedx;
        this.speedY = speedy;
        this.radius = width/2;
        this.sprite = new Sprite(new Texture("enemy.png"));
        sprite.setSize(width,height);
        sprite.setAlpha(hp/60f);

    }

    void takeDamage(float damage) {
       if(!spawned) {
           this.hp -= damage;
           //System.out.println("Damage taken: " + hp/100f);
           sprite.setAlpha(hp / 100f + .40f);
           if (this.hp <= 0) {
               dying = true;
           }
       }
    }
    void recover() {
        if(spawned) {
            sprite.setAlpha(hp/60f);
            hp *= 1.025;
            if(hp >= 60) {
                hp = 60;
                spawned = false;
            }
        }
    }

    void update() {
        this.move();
        if(this.spawned) {
            recover();
        }
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

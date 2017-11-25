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
    int width, height;
    Sprite sprite;
    String direc;
    Texture img;
    //Player player = new Player();

    public Enemy(int x, int y, int speed, int speedy) {
        this.x = x;
        this.y = y;
        this.speedX = speed;
        this.speedY = speedy;
        this.width = 100;
        this.height = 100;
        img = new Texture("enemy.png");
        this.sprite = new Sprite(img);
        this.sprite.setSize(width, height);
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
    /*
    void move(Boolean direction) {
        if (direction) {
            Random rn = new Random();
            int answer = rn.nextInt(3);

            if (answer == 0){
                this.x += speedX;
                direc = "east";
            } else if (answer == 1){
                this.x -= speedX;
                direc = "west";
            } else if (answer == 2){
                this.y += speedY;
                direc = "north";
            } else if (answer == 3) {
                this.y -= speedY;
                direc = "south";
            }


        } else {
            if(direc == "north") {
                this.y += speedY;
            } else if(direc == "east"){
                this.x += speedX;
            } else if(direc == "west") {
                this.x -= speedX;
            } else if(direc == "south") {
                this.y -= speedY;
            }
        }

    }
    */
    void draw(SpriteBatch batch) {
        this.sprite.setPosition(x,y);
        this.sprite.draw(batch);
    }

}

package com.heatfeet;

/**
 * Created by alqio on 25.11.2017.
 */
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Player {
    float x, y, width, height;
    ArrayList<Pair> melts = new ArrayList();
    Sprite sprite;
    Accelometer meter;
    int rmv = 0;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 100;
        this.sprite = new Sprite(new Texture("player.png"));
        meter = new Accelometer();
    }

    void move() {

        meter.update();

        x += meter.ax;
        y += meter.ay;
 
        melts.add(new Pair((int) x,(int) y));
        if(rmv == 100){
            melts.remove(0);
        }else{
            rmv++;
        }
        //x+= 1;
        //y+= 1;
    }
    /*void melt() {
        //if(melts.contains())
        for(int i = 1; i < melts.size(); i++){
            System.out.print("MOI");
            //sr.rectLine(melts.get(i-1)._1, melts.get(i-1)._2, melts.get(i)._1, melts.get(i)._2, i/5);
            sr.rectLine(20+i*2,20+i*2,200,200, i/5);
        }

    }*/

    void draw(SpriteBatch batch) {
        this.sprite.setPosition(x,y);
        this.sprite.draw(batch);
    }

}

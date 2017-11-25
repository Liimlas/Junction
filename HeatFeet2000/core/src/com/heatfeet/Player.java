package com.heatfeet;

/**
 * Created by alqio on 25.11.2017.
 */
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Player extends Instance {
    ArrayList<Pair> melts = new ArrayList();

    private Accelometer meter;
    int rmv = 0;

    public Player(int x, int y, float width, float height) {
        super(x, y);
        this.sprite = new Sprite(new Texture("junction_ball.png"));
        this.sprite.setSize(width, height);
        meter = new Accelometer();
    }

    void update() {

    }

    void move() {
        meter.update();

        if(meter.ax > 0){
            x += (int) meter.ax;
        }
        if(meter.ay < 0){
            y += (int) meter.ay;
        }
        if(meter.ax < 0){
            x += (int) meter.ax;
        }
        if(meter.ay > 0){
            y += (int) meter.ay;
        }
        if(x > Gdx.graphics.getWidth()){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight()){
            y = 0;
        }
        if(y < (-1)*height){
            y = Gdx.graphics.getHeight();
        }
        if(x < (-1)*width){
            x = Gdx.graphics.getWidth();
        }

        melts.add(new Pair((int) x,(int) y));
        if(rmv == 100){
            melts.remove(0);
        }else{
            rmv++;
        }
    }

    void draw_melts(ShapeRenderer sr) {
        for(int i = 1; i < this.melts.size(); i++){
            sr.setColor(new Color((float) (i * 2),0,0,100));
            sr.circle(this.melts.get(i)._1, this.melts.get(i)._2 ,i/3);
            sr.circle((this.melts.get(i)._1 + this.melts.get(i-1)._1)/2, (this.melts.get(i)._2 + this.melts.get(i-1)._2)/2 ,i/3);

            //sr.rectLine(player.melts.get(i-1)._1, player.melts.get(i-1)._2, player.melts.get(i)._1, player.melts.get(i)._2, i/10);
            //sr.el(player.melts.get(i)._1, player.melts.get(i)._2, i/5);
            //sr.rectLine(20+i*2,20+i*2,200,200, i/5);
        }

    }
}

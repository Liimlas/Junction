package com.heatfeet;

/**
 * Created by alqio on 25.11.2017.
 */
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import static java.lang.Math.max;

import java.util.ArrayList;

public class Player extends Instance {
    ArrayList<MeltParticle> melts = new ArrayList();
    int immortalFor;
    int lives;


    private Accelometer meter;
    int rmv = 0;
    float fullDamage = 5;
    float speedx = 0;
    float speedy = 0;

    public Player(int x, int y, float radius) {
        super(x, y);
        this.radius = radius;
        this.sprite = new Sprite(new Texture("junction_ball.png"));

        this.sprite.setSize(radius, radius);
        meter = new Accelometer();
        lives = 3;
        immortalFor = 0;
    }

    void update() {
        meter.update();
        this.move();
        int deaths = 0;
        for (MeltParticle particle : melts) {
            particle.update();
            if (particle.dying) {
                deaths += 1;
            }
        }
        for (int i = 0; i < deaths; i++) {
            melts.remove(0);
        }
        immortalFor = max(0, immortalFor - 1);
    }

    void move() {


        if(meter.ax > 0){
            speedx = Math.min(meter.ax / 4 + speedx, 8);
            x += ((int) speedx);
        }
        if(meter.ax < 0){
            speedx = Math.max(meter.ax / 4 + speedx, -8);
            x += ((int) speedx);
        }
        if(meter.ay > 0){
            speedy = Math.min(meter.ay / 4 + speedy, 8);
            y += ((int) speedy);
        }
        if(meter.ay < 0){
            speedy = Math.max(meter.ay / 4 + speedy, -8);
            y += ((int) speedy);
        }

        if(x > Gdx.graphics.getWidth()){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight()){
            y = 0;
        }
        if(y < (-1)*radius*2){
            y = Gdx.graphics.getHeight();
        }
        if(x < (-1)*radius*2){
            x = Gdx.graphics.getWidth();
        }


        if (melts.size() < 240) {
            MeltParticle particle = new MeltParticle(x, y);
            melts.add(particle);
        }
    }
    //mitä pienempi i, sitä vanhempi kohta
    void draw_melts(ShapeRenderer sr) {
        for(int i = 1; i < this.melts.size(); i++){
            float a = 2f/255f;

            MeltParticle particle = this.melts.get(i);

            sr.setColor(new Color((i*2)/255f,0,(255-(i*2))/255f,180));
            sr.circle(particle.x, particle.y, particle.radius);
            if (java.lang.Math.abs(particle.x - this.melts.get(i -1).x) < 40 && java.lang.Math.abs(particle.y - this.melts.get(i -1).y) < 40) {
                sr.circle((particle.x + this.melts.get(i-1).x)/2, (particle.y + this.melts.get(i-1).y)/2 ,particle.radius);
            }


        }
    }
}

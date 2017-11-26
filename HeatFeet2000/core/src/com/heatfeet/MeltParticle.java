package com.heatfeet;

import com.badlogic.gdx.math.Circle;

/**
 * Created by alqio on 25.11.2017.
 */

public class MeltParticle {
    float x,y, radius, damage;
    boolean dying = false;

    public MeltParticle(float x, float y) {
        this.x = x;
        this.y = y;
        this.radius = 50;
        this.damage = this.radius/100f;
    }

    void update() {
        this.radius -= this.radius*0.03f;
        this.damage = this.radius/100f;
        if (this.radius <= 1f) {
            this.dying = true;
        }
    }
    Circle hitArea() {
        return new Circle(x,y,radius);
    }

}

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
        this.damage = 0.2f;
    }

    void update() {
        this.radius -= 1.0f/1.2f;
        this.damage -= 0.1f/120.0f;
        if (this.radius <= 0.0f) {
            this.dying = true;
        }
    }
    Circle hitArea() {
        return new Circle(x,y,radius);
    }

}

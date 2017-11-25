package com.heatfeet;

import com.badlogic.gdx.Gdx;
/**
 * Created by alqio on 25.11.2017.
 */

public class Accelometer {

    float ax, ay, az;

    public void update() {
        ax = Gdx.input.getAccelerometerX();
        ay = Gdx.input.getAccelerometerY();
        az = Gdx.input.getAccelerometerZ();
        System.out.println("ax: " + ax + ", ay: " + ay + ", az: " + az);
    }

}

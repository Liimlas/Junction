package com.heatfeet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by alqio on 25.11.2017.
 */

public class Accelometer {

    float ax, ay, az;

    boolean available = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);

    public void update() {
        ax = -Gdx.input.getAccelerometerX();
        ay = -Gdx.input.getAccelerometerY();
        az = -Gdx.input.getAccelerometerZ();
        System.out.println("available: " + available + ", ax: " + ax + ", ay: " + ay + ", az: " + az);
    }

}

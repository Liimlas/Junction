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
        ax = -3*Gdx.input.getAccelerometerX();
        ay = -3*Gdx.input.getAccelerometerY();
        az = -3*Gdx.input.getAccelerometerZ();
        //System.out.println("available: " + available + ", ax: " + ax + ", ay: " + ay + ", az: " + az);
    }

}

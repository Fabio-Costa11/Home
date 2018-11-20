package com.example.asus.home;

/**
 * Created by Asus on 03/02/2017.
 */
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

import ketai.sensors.*;
import ketai.ui.*;
import processing.core.PVector;

public class Sketch extends PApplet {


    ///////////////////////////////////////////////////////////////////
    //Projecto nº 6

    KetaiSensor sensor;
    PVector magneticField, accelerometer;
    float light, proximity;
    KetaiVibrate vib;

    public void settings() {
        size(900, 500);
    }


    public void setup()
    {
        sensor = new KetaiSensor(this);
        sensor.start();
        sensor.list();
        accelerometer = new PVector();
        magneticField = new PVector();
        orientation(LANDSCAPE);
        textAlign(CENTER, CENTER);
        textSize(28);
        vib = new KetaiVibrate(this);
    }

    public void draw()
    {
        background(78, 93, 75);
        text("Accelerometer :" + "\n"
                        + "x: " + nfp(accelerometer.x, 1, 2) + "\n"
                        + "y: " + nfp(accelerometer.y, 1, 2) + "\n"
                        + "z: " + nfp(accelerometer.z, 1, 2) + "\n"
                        + "MagneticField :" + "\n"
                        + "x: " + nfp(magneticField.x, 1, 2) + "\n"
                        + "y: " + nfp(magneticField.y, 1, 2) + "\n"
                        + "z: " + nfp(magneticField.z, 1, 2) + "\n"
                        + "Light Sensor : " + light + "\n"
                        + "Proximity Sensor : " + proximity + "\n"
                , 20, 0, width, height);
    }

    void onAccelerometerEvent(float x, float y, float z, long time, int accuracy)
    {
        accelerometer.set(x, y, z);
    }

    void onMagneticFieldEvent(float x, float y, float z, long time, int accuracy)
    {
        magneticField.set(x, y, z);
    }

    void onLightEvent(float v)
    {
        light = v;
    }

    void onProximityEvent(float v)
    {
        proximity = v;
    }

    public void mousePressed() {
        if (sensor.isStarted()) {
            sensor.stop();
            vib.vibrate(100);
        }
        else
            sensor.start();
        println("KetaiSensor isStarted: " + sensor.isStarted());
    }
}
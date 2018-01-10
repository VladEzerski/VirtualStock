package com.ezerski.vladislav.virtualstock;

import android.widget.GridView;

import java.util.Random;

public class MyThread implements Runnable{

    private GridView gridView;

    RobotsMoving robot  = new RobotsMoving(gridView);

    final Random random = new Random();
    final int dir = random.nextInt(4);

    final int position = robot.returnRobotsPosition();

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            robot.robotsMoving(position, dir);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

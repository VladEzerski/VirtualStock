package com.ezerski.vladislav.virtualstock;

import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.services.storage.MapStorage;

import java.util.Random;

public class MyThread implements Runnable {

    private GridView gridView;

    public MyThread(GridView gridView) {
        this.gridView = gridView;
    }

    RobotsMoving robot = new RobotsMoving(gridView);
    ReturnElementPosition element = new ReturnElementPosition();

    private final Random random = new Random();

    private int exitPosition = element.returnElementPosition(MapStorage.EXIT);



    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);

                int[] robotsPosition = robot.returnRobotsPosition();
                final int dir = random.nextInt(4);
                for (int i = 0; i < robotsPosition.length; i++) {
                    robot.robotsMoving(robotsPosition[i], dir);
                    if (robotsPosition[i] == exitPosition) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
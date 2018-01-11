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

    final Random random = new Random();
    final int dir = random.nextInt(4);


    final int exitPosition = robot.returnSymbolsPosition(MapStorage.EXIT);

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (true) {
                int robotPosition = robot.returnSymbolsPosition(MapStorage.ROBOT);
                int exitPosition = robot.returnSymbolsPosition(MapStorage.EXIT);
                robot.robotsMoving(robotPosition, dir);
                if (robotPosition == exitPosition) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

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
    ReturnElementPosition element = new ReturnElementPosition(gridView);

    final Random random = new Random();
    final int dir = random.nextInt(4);

    int exitPosition = element.returnElementPosition(MapStorage.EXIT);
    int enterPosition = element.returnElementPosition(MapStorage.START);

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (true) {
                redrawing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void redrawing(){
        int[] massPositions = robot.returnRobotsPosition();
        while (true) {
            robot.robotsMoving(massPositions[0], dir);
            if (massPositions[0] == exitPosition) {
                break;
            }
        }
        gridView.invalidateViews();
    }
}

package com.ezerski.vladislav.virtualstock.services.impl;

import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.MainActivity;
import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import java.util.List;
import java.util.Random;
import java.util.TimerTask;

//todo add custom extended from Runneble interface
public class CustomRobotsMovingTimer extends TimerTask {

    private GridView gridView;

    private final MainActivity mainActivity;

    private RobotsMover robot = new RobotsMover();
    private Integer exitPosition = new ElementPositionProvider().returnElementPosition(MapStorage.EXIT);

    public CustomRobotsMovingTimer(GridView gridView, MainActivity mainActivity) {
        this.gridView = gridView;
        this.mainActivity = mainActivity;
    }

    @Override
    public void run() {
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((ArrayAdapter) gridView.getAdapter()).notifyDataSetInvalidated();
                List<Integer> robotsPosition = robot.returnRobotsPosition();

                for (Integer position : robotsPosition) {
                    final int dir = new Random().nextInt(4);
                    robot.robotsMoving(position, dir);
                    if (position.equals(exitPosition)) {
                        break;
                    }
                }
            }
        });

    }
}
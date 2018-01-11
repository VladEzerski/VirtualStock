package com.ezerski.vladislav.virtualstock.services.impl;

import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;
import static com.ezerski.vladislav.virtualstock.storage.MapStorage.VERTICAL_SIZE;

//todo add interface
public class RobotsMover {

    private GridView gridView;

    public RobotsMover(GridView gridView) {
        this.gridView = gridView;
    }

    public void robotsMoving(int position, int direction) {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        //todo enum
        if (direction == 0) {
            mapUpdating(map.toString(), position, position - HORIZONTAL_SIZE);
        }
        if (direction == 1) {
            mapUpdating(map.toString(), position, position + 1);
        }
        if (direction == 2) {
            mapUpdating(map.toString(), position, position + HORIZONTAL_SIZE);
        }
        if (direction == 3) {
            mapUpdating(map.toString(), position, position - 1);
        }
    }

    public List<Integer> returnRobotsPosition() {

        StringBuilder map = new StringBuilder();
        List<Integer> robotPositions = new ArrayList<>();

        for (int i = 0; i < VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }

        for (int i = 0; i < map.length(); i++) {
            if (map.charAt(i) == MapStorage.ROBOT) {
                robotPositions.add(i);
            }
        }
        return robotPositions;
    }

    private void mapUpdating(String mapString, int position, int destination) {
        List<String> mapList = new ArrayList<>();

        StringBuilder newAppendedString = new StringBuilder();
        StringBuilder mapStringBuilder = new StringBuilder(mapString);

        for (int i = 0; i < mapString.length(); i++) {
            if (i == position) {
                newAppendedString.append(mapStringBuilder.charAt(destination));
            } else if (i == destination) {
                newAppendedString.append(mapStringBuilder.charAt(position));
            } else {
                newAppendedString.append(mapStringBuilder.charAt(i));
            }

            if ((i + 1) % HORIZONTAL_SIZE == 0) {
                mapList.add(newAppendedString.toString());
                newAppendedString = new StringBuilder();
            }
        }
        MapStorage.MAP = mapList;
    }
}

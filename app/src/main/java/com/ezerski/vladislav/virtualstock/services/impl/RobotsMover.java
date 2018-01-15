package com.ezerski.vladislav.virtualstock.services.impl;

import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;
import static com.ezerski.vladislav.virtualstock.storage.MapStorage.VERTICAL_SIZE;

//todo add interface
public class RobotsMover {

    private final ElementPositionProvider elementPositionProvider = new ElementPositionProvider();

    public void robotsMoving(int position, int direction) {
        String map = elementPositionProvider.provideMapAsString().toString();

        //todo enum
        switch (direction) {
            case 0:
                if (checkValidPosition(position - HORIZONTAL_SIZE)) {
                    mapUpdating(map, position, position - HORIZONTAL_SIZE);
                    break;
                }
            case 1:
                if (checkValidPosition(position + 1)) {
                    mapUpdating(map, position, position + 1);
                    break;
                }
            case 2:
                if (checkValidPosition(position + HORIZONTAL_SIZE)) {
                    mapUpdating(map, position, position + HORIZONTAL_SIZE);
                    break;
                }
            case 3:
                if (checkValidPosition(position - 1)) {
                    mapUpdating(map, position, position - 1);
                    break;
                }
        }
    }


    public synchronized List<Integer> returnRobotsPosition() {

        StringBuilder map = elementPositionProvider.provideMapAsString();
        List<Integer> robotPositions = new ArrayList<>();

        for (int i = 0; i < map.length(); i++) {
            if (map.charAt(i) == MapStorage.ROBOT) {
                robotPositions.add(i);
            }
        }
        return robotPositions;
    }

    private synchronized void mapUpdating(String mapString, int position, int destination) {
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

    private boolean checkValidPosition(int position) {
        String map = elementPositionProvider.provideMapAsString().toString();
        return position > HORIZONTAL_SIZE && position < ((HORIZONTAL_SIZE - 1) * VERTICAL_SIZE)
                && position % (HORIZONTAL_SIZE - 1) != 0 && (position % HORIZONTAL_SIZE != 0)
                && map.charAt(position) == MapStorage.SPACE;
    }
}

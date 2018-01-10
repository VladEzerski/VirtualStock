package com.ezerski.vladislav.virtualstock;

import android.widget.GridView;

import com.ezerski.vladislav.virtualstock.services.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ezerski.vladislav.virtualstock.services.storage.MapStorage.HORIZONTAL_SIZE;

public class RobotsMoving {

    private GridView gridView;

    public RobotsMoving(GridView gridView) {
        this.gridView = gridView;
    }

    public void robotsMoving(int position, int direction) {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
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

    public void mapUpdating(String mapString, int position, int destination) {
        List<String> mapList = new ArrayList<>();

        StringBuilder newAppendedString = new StringBuilder();
        StringBuilder mapStringBuilder = new StringBuilder(mapString);

        for (int i = 0; i < mapString.length(); i++) {
            if (i == position) {
                newAppendedString.append(mapStringBuilder.charAt(destination));
            } else if (i == destination){
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

    public int returnRobotsPosition(){
        String str = String.valueOf(MapStorage.ROBOT);
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        int pos = map.indexOf(str);

       return pos;
    }
}

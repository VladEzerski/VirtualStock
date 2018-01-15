package com.ezerski.vladislav.virtualstock.services;


import com.ezerski.vladislav.virtualstock.R;
import com.ezerski.vladislav.virtualstock.services.impl.ElementPositionProvider;
import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;

//todo add interface
public class MapReturner {

    private final Random random = new Random();

    public int provideImageId(int position) {
        StringBuilder map = new ElementPositionProvider().provideMapAsString();
        return getIdByChar(map.charAt(position));
    }

    public void generateRobotsOnMap() {
        StringBuilder map = new ElementPositionProvider().provideMapAsString();
        int n = MapStorage.ROBOT_COUNT;
        int k = 0;
        while (k < n) {
            int rand = random.nextInt(map.length());
            if (map.charAt(rand) == MapStorage.SPACE) {
                map.replace(rand, rand + 1, String.valueOf(MapStorage.ROBOT));
                k++;
            }
        }

        List<String> mapList = new ArrayList<>();
        StringBuilder newAppendedString = new StringBuilder();

        for (int i = 0; i < map.length(); i++) {
            newAppendedString.append(map.charAt(i));
            if ((i + 1) % HORIZONTAL_SIZE == 0) {
                mapList.add(newAppendedString.toString());
                newAppendedString = new StringBuilder();
            }
        }
        MapStorage.MAP = mapList;
    }

    //todo rewrite to enum
    public int getIdByChar(char charValue) {

        if (charValue == MapStorage.HORIZONTAL_BOARD) {
            return R.drawable.shape_rectangle_black;
        }

        if (charValue == MapStorage.VERTICAL_BOARD) {
            return R.drawable.shape_rectangle_black;
        }

        if (charValue == MapStorage.SPACE) {
            return R.drawable.shape_rectangle_gray;
        }

        if (charValue == MapStorage.EXIT) {
            return R.drawable.shape_rectangle_yellow;
        }

        if (charValue == MapStorage.ROBOT) {
            return R.drawable.shape_rectangle_red;
        }

        if (charValue == MapStorage.BOX) {
            return R.drawable.shape_rectangle_green;
        }

        if (charValue == MapStorage.START) {
            return R.drawable.shape_rectangle_yellow;
        }

        throw new IllegalArgumentException("Invalid map char value");
    }
}

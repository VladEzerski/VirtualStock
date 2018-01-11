package com.ezerski.vladislav.virtualstock.services;


import com.ezerski.vladislav.virtualstock.R;
import com.ezerski.vladislav.virtualstock.storage.MapStorage;

//todo add interface
public class MapReturner {

    public int provideImageId(int position) {
        StringBuilder unionMap = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
            for (int j = 0; j < MapStorage.HORIZONTAL_SIZE; j++) {
                unionMap.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        return getIdByChar(unionMap.charAt(position));
    }

    //todo rewrite to enum
    public int getIdByChar(char charValue) {

        if (charValue == MapStorage.HORIZONT_BOARD) {
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

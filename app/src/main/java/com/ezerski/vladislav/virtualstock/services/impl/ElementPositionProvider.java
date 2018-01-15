package com.ezerski.vladislav.virtualstock.services.impl;

import com.ezerski.vladislav.virtualstock.storage.MapStorage;

import static com.ezerski.vladislav.virtualstock.storage.MapStorage.HORIZONTAL_SIZE;

//todo add interface
//todo change on singleton
public class ElementPositionProvider {


    public Integer returnElementPosition(char element) {
        String str = String.valueOf(element);
        return provideMapAsString().indexOf(str);
    }


    public StringBuilder provideMapAsString() {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        return map;
    }

}

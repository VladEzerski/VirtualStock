package com.ezerski.vladislav.virtualstock;

import com.ezerski.vladislav.virtualstock.services.storage.MapStorage;

import static com.ezerski.vladislav.virtualstock.services.storage.MapStorage.HORIZONTAL_SIZE;

public class ReturnElementPosition {

    public int returnElementPosition(char element){
        String str = String.valueOf(element);
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        return map.indexOf(str);
    }
}

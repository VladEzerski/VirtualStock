package com.ezerski.vladislav.virtualstock;

import android.widget.GridView;
import android.widget.ImageView;

import com.ezerski.vladislav.virtualstock.services.MapReturner;
import com.ezerski.vladislav.virtualstock.services.storage.MapStorage;

import java.util.ArrayList;

import static com.ezerski.vladislav.virtualstock.services.storage.MapStorage.HORIZONTAL_SIZE;

public class RedrawMap {

    private GridView gridView;

    public RedrawMap(GridView gridView) {
        this.gridView = gridView;
    }

    public void robotMove(int position, int direction) {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < MapStorage.VERTICAL_SIZE; i++) {
            for (int j = 0; j < HORIZONTAL_SIZE; j++) {
                map.append(MapStorage.MAP.get(i).charAt(j));
            }
        }
        //todo enum
        if (direction == 0) {
            robotsMoving(map.toString(), position, position - HORIZONTAL_SIZE);
        }
        if (direction == 1) {
            robotsMoving(map.toString(), position, position + 1);
        }
        if (direction == 2) {
            robotsMoving(map.toString(), position, position + HORIZONTAL_SIZE);
        }
        if (direction == 3) {
            robotsMoving(map.toString(), position, position - 1);
        }
    }

    public void reDraw(int position, int destination, int idImageFrom, int idImageDestination) {
        ImageView view = (ImageView) gridView.getAdapter().getView(position, null, gridView);
        view.setImageResource(idImageFrom);

    }

    public void robotsMoving(String mapString, int position, int destination) {
        ArrayList<String> mapList = new ArrayList<String>();
        reDraw(position, destination, new MapReturner().provideImageId(position),
                new MapReturner().provideImageId(destination));
        for (int i = 0; i < mapString.length(); i++) {
            if (i == position) {
                position = destination;
                destination = i;
                if (i % HORIZONTAL_SIZE == 0) {
                    String str = mapString.substring(0, i);
                    mapList.add(str);
                }
            }
        }
    }
}

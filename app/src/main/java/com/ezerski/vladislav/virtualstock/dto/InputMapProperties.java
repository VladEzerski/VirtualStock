package com.ezerski.vladislav.virtualstock.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 06.01.2018.
 */

public class InputMapProperties {
    private List<String> map = new ArrayList<>();
    private int verticalSize = 0;
    private int horizontalSize = 0;

    public List<String> getMap() {

        return map;
    }

    public void setMap(List<String> map) {
        this.map = map;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }
    @Override
    public String toString() {
        return "InputMapProperties{" +
                "map=" + map +
                ", verticalSize=" + verticalSize +
                ", horizontalSize=" + horizontalSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputMapProperties that = (InputMapProperties) o;

        if (verticalSize != that.verticalSize) return false;
        if (horizontalSize != that.horizontalSize) return false;
        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode() {
        int result = map != null ? map.hashCode() : 0;
        result = 31 * result + verticalSize;
        result = 31 * result + horizontalSize;
        return result;
    }
}

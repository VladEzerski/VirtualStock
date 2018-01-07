package com.ezerski.vladislav.virtualstock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class InputMapProperties {

    @JsonProperty("vertical_size")
    private int verticalSize = 0;
    @JsonProperty("horizontal_size")
    private int horizontalSize = 0;

    @JsonProperty("vertical_board")
    private char verticalBoard = '|';
    @JsonProperty("horizontal_board")
    private char horizontalBoard = '-';

    private char space = '.';
    private char start = 'S';
    private char exit = 'E';
    private char box = 'X';
    private char robot = '*';

    private List<String> map = new ArrayList<>();

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

    public char getVerticalBoard() {
        return verticalBoard;
    }

    public void setVerticalBoard(char verticalBoard) {
        this.verticalBoard = verticalBoard;
    }

    public char getHorizontalBoard() {
        return horizontalBoard;
    }

    public void setHorizontalBoard(char horizontalBoard) {
        this.horizontalBoard = horizontalBoard;
    }

    public char getSpace() {
        return space;
    }

    public void setSpace(char space) {
        this.space = space;
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getExit() {
        return exit;
    }

    public void setExit(char exit) {
        this.exit = exit;
    }

    public char getBox() {
        return box;
    }

    public void setBox(char box) {
        this.box = box;
    }

    public char getRobot() {
        return robot;
    }

    public void setRobot(char robot) {
        this.robot = robot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputMapProperties that = (InputMapProperties) o;

        if (verticalSize != that.verticalSize) return false;
        if (horizontalSize != that.horizontalSize) return false;
        if (verticalBoard != that.verticalBoard) return false;
        if (horizontalBoard != that.horizontalBoard) return false;
        if (space != that.space) return false;
        if (start != that.start) return false;
        if (exit != that.exit) return false;
        if (box != that.box) return false;
        if (robot != that.robot) return false;
        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode() {
        int result = map != null ? map.hashCode() : 0;
        result = 31 * result + verticalSize;
        result = 31 * result + horizontalSize;
        result = 31 * result + (int) verticalBoard;
        result = 31 * result + (int) horizontalBoard;
        result = 31 * result + (int) space;
        result = 31 * result + (int) start;
        result = 31 * result + (int) exit;
        result = 31 * result + (int) box;
        result = 31 * result + (int) robot;
        return result;
    }

    @Override
    public String toString() {
        return "InputMapProperties{" +
                "map=" + map +
                ", verticalSize=" + verticalSize +
                ", horizontalSize=" + horizontalSize +
                ", verticalBoard=" + verticalBoard +
                ", horizontalBoard=" + horizontalBoard +
                ", space=" + space +
                ", start=" + start +
                ", exit=" + exit +
                ", box=" + box +
                ", robot=" + robot +
                '}';
    }
}

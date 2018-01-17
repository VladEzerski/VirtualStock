package com.ezerski.vladislav.virtualstock.services;

public enum Direction {
    UP(0),
    RIGHT(1),
    DOWN(2),
    lEFT(3);

    public final int direction;

    Direction(int direction) {
        this.direction = direction;
    }
}

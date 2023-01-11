package com.mowitnow.kata.model;

public enum MowerDirection {
    N("NORTH"), E("EAST"), S("SOUTH"), W("WEST");
    private final String direction;

    MowerDirection(String direction) {
        this.direction = direction;
    }
}

package com.mowitnow.kata.model;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Builder (toBuilder = true)
public class Mower {
    private Long id;
    private Position position;
    private MowerDirection direction;

    @Override
    public String toString() {
        return position.getX() +
                " " + position.getY() +
                " " + direction;
    }
}

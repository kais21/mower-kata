package com.mowitnow.kata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private int X;
    private int Y;

    @Override
    public String toString() {
        return X + " " + Y;
    }
}

package com.mowitnow.kata.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public class Lawn {
    private Position topRightCorner;
    private Map<Mower, List<MowerInstruction>> mowersInstructions;
}

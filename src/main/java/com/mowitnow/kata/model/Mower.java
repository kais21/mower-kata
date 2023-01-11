package com.mowitnow.kata.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Mower {
    private Long id;
    private Position position;
    private MowerDirection direction;

}

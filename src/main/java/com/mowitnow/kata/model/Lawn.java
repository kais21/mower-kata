package com.mowitnow.kata.model;

import lombok.*;

import java.util.List;
@Getter
@Builder
public class Lawn {
    private long id ;
    private Position topRightCorner ;
    private List<Mower> mowers ;
}

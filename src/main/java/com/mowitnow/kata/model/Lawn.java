package com.mowitnow.kata.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class Lawn {
    private long id ;
    private Position topRightCorner ;
    private Map<Mower,String> mowersInstruction ;
}

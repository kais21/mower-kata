package com.mowitnow.kata.model;

public enum MowerInstruction {
    D("RIGHT"), G("LEFT"), A("FORWARD");
    private final String instruction;

    MowerInstruction(String instruction) {
        this.instruction = instruction;
    }
}

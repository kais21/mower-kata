package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.Mower;
import com.mowitnow.kata.model.MowerInstruction;

public class MowerServiceMgr implements MowerService {
    @Override
    public String executeInstructionsFile(String filePath, String fileName) throws IncorrectFileException {
        return "";
    }

    @Override
    public Mower executeInstruction(Mower mower, MowerInstruction instruction) {
        return Mower.builder().build();
    }
}

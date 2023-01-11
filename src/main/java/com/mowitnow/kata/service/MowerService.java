package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.Mower;
import com.mowitnow.kata.model.MowerInstruction;
import com.mowitnow.kata.model.Position;

import java.io.IOException;

public interface MowerService {
    public String executeInstructionsFile(String fileName, String filePath) throws IncorrectFileException, IOException;
    public void executeInstruction(Mower mower, MowerInstruction instruction, Position lawnTopRightCorner);

}

package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.Mower;
import com.mowitnow.kata.model.MowerInstruction;

public interface MowerService {
    public String executeInstructionsFile(String fileName, String filePath) throws IncorrectFileException;
    public Mower executeInstruction(Mower mower, MowerInstruction instruction);

}

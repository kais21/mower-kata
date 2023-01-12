package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.Lawn;

import java.io.IOException;

public interface MowerService {
    String executeInstruction(String fileName, String filePath) throws IncorrectFileException, IOException;

    String executeInstruction(Lawn lawn);
}

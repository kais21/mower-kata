package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

import static com.mowitnow.kata.util.FileTranslatorUtil.translateFile;
import static com.mowitnow.kata.util.MowerUtil.*;

public class MowerServiceMgr implements MowerService {

    @Override
    public String executeInstructionsFile(String fileName, String filePath) throws IncorrectFileException, IOException {
        Lawn lawn = translateFile(fileName, filePath);
        return lawn.getMowersInstruction().entrySet().stream()
                .map(kv -> executeInstruction(kv.getKey(), kv.getValue(), lawn.getTopRightCorner()))
                .collect(Collectors.joining(" "));

    }

    public String executeInstruction(Mower mower, String instructions, Position lawnTopRightCorner) {
        instructions.chars()
                .forEach(c -> {
                        MowerInstruction instruction = MowerInstruction.valueOf(String.valueOf((char) c));
                        executeInstruction(mower, instruction, lawnTopRightCorner);
                });
        return mower.toString();
    }

    @Override
    public void executeInstruction(Mower mower, MowerInstruction instruction, Position lawnTopRightCorner) {
        switch (instruction) {
            case A:
                goForward(mower, lawnTopRightCorner);
                break;
            case D:
                turnRight(mower);
                break;
            case G:
                turnLeft(mower);
                break;
        }
    }
}

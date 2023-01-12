package com.mowitnow.kata.service;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.*;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.mowitnow.kata.io.FileTranslator.translateFile;
import static com.mowitnow.kata.io.FileTranslatorConst.DELIMITER;

public class MowerServiceMgr implements MowerService {

    @Override
    public String executeInstruction(String fileName, String filePath) throws IncorrectFileException, IOException {
        return executeInstruction(translateFile(fileName, filePath));
    }

    @Override
    public String executeInstruction(Lawn lawn) {
        return lawn.getMowersInstructions().entrySet().stream()
                .map(kv -> {
                    kv.getValue().forEach(ins -> executeInstruction(kv.getKey(), ins, lawn.getTopRightCorner()));
                    return kv.getKey().toString();
                })
                .collect(Collectors.joining(DELIMITER));
    }

    private void executeInstruction(Mower mower, MowerInstruction instruction, Position lawnTopRightCorner) {
        switch (instruction) {
            case A:
                mower.goForward(lawnTopRightCorner);
                break;
            case D:
                mower.turnRight();
                break;
            case G:
                mower.turnLeft();
                break;
        }
    }
}

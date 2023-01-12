package com.mowitnow.kata.io;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.mowitnow.kata.io.FileTranslatorConst.*;

public class FileTranslator {

    public static Lawn translateFile(String fileName, String filePath) throws IncorrectFileException, IOException {
        List<String> allLines = Files.readAllLines(Paths.get(filePath, fileName));
        if (allLines.size() < 3 || allLines.size() % 2 == 0) {
            throw new IncorrectFileException(fileName, LINES_MESSAGE);
        }
        long idMower = 0;
        Iterator<String> linesIterator = allLines.iterator();
        Position lawnPosition = toPosition(linesIterator.next());
        Map<Mower, List<MowerInstruction>> instructionsMower = new LinkedHashMap<>();
        while (linesIterator.hasNext()) {
            Mower mower = toMower(linesIterator.next(), idMower++);
            List<MowerInstruction> instructions = toMowerInstructions(linesIterator.next());
            instructionsMower.put(mower, instructions);
        }
        return Lawn.builder().
                topRightCorner(lawnPosition).
                mowersInstructions(instructionsMower).build();
    }

    private static List<MowerInstruction> toMowerInstructions(String line) throws IncorrectFileException {
        List<MowerInstruction> instructions = new LinkedList<>();
        for (Character c : line.toCharArray()) {
            try {
                MowerInstruction ins = MowerInstruction.valueOf(c.toString());
                instructions.add(ins);
            } catch (IllegalArgumentException e) {
                throw new IncorrectFileException(line, e.getMessage());
            }
        }
        return instructions;
    }

    private static Mower toMower(String line, long idMower) throws IncorrectFileException {
        Position position = toPosition(line);
        MowerDirection direction = toMowerDirection(line);
        return Mower.builder().id(idMower).position(position).direction(direction).build();
    }

    private static MowerDirection toMowerDirection(String line) throws IncorrectFileException {
        String[] splits = line.split(DELIMITER);
        if (splits.length < 3) throw new IncorrectFileException(line, DIRECTION_MESSAGE);
        return MowerDirection.valueOf(splits[DIRECTION_INDEX]);
    }

    private static Position toPosition(String line) throws IncorrectFileException {
        String[] splits = line.split(DELIMITER);
        if (splits.length < 2) throw new IncorrectFileException(line, POSITION_MESSAGE);
        int x = Integer.parseInt(splits[X_INDEX]);
        int y = Integer.parseInt(splits[Y_INDEX]);
        if (x < 0 || y < 0) throw new IncorrectFileException(line, COORDINATE_MESSAGE);
        return new Position(x, y);
    }

    private FileTranslator() {
    }
}

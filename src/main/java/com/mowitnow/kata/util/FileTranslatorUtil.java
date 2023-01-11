package com.mowitnow.kata.util;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.Lawn;
import com.mowitnow.kata.model.Mower;
import com.mowitnow.kata.model.MowerDirection;
import com.mowitnow.kata.model.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileTranslatorUtil {
    public static Lawn translateFile(String fileName, String filePath) throws IncorrectFileException, IOException {
        String uri = filePath + fileName;
        List<String> allLines = Files.readAllLines(Paths.get(uri));
        if (allLines.size() < 3 || allLines.size() % 2 == 0)
            throw new IncorrectFileException();

        Iterator<String> linesIterator = allLines.iterator();
        Position lawnPosition = toPosition(linesIterator.next());
        Map<Mower, String> instructionsMower = new HashMap<>();
        while (linesIterator.hasNext()) {
            Mower mower = toMower(linesIterator.next());
            String instruction = linesIterator.next();
            instructionsMower.put(mower, instruction);
        }
        return Lawn.builder()
                .topRightCorner(lawnPosition)
                .mowersInstruction(instructionsMower)
                .build();
    }

    private static Mower toMower(String line) throws IncorrectFileException {
        Position position = toPosition(line);
        MowerDirection direction = toMowerDirection(line);
        return Mower.builder()
                .position(position)
                .direction(direction).build();
    }

    private static MowerDirection toMowerDirection(String line) throws IncorrectFileException {
        String[] splits = line.split(" ");
        if (splits.length < 3)
            throw new IncorrectFileException();
        return MowerDirection.valueOf(splits[2]);
    }

    private static Position toPosition(String line) throws IncorrectFileException {
        String[] splits = line.split(" ");
        if (splits.length < 2)
            throw new IncorrectFileException();
        int x = Integer.valueOf(splits[0]);
        int y = Integer.valueOf(splits[1]);
        if(x<0 || y< 0)
            throw new IncorrectFileException();
        return new Position(x, y);
    }
}

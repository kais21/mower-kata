package com.mowitnow.kata.unit;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.io.FileTranslator;
import com.mowitnow.kata.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.mowitnow.kata.model.MowerInstruction.*;

public class FileTranslatorTest {
    private final String FILEPATH = "src/test/resources/com/mowitnow/kata/in/";
    private final String FILENAME = "correctFile.txt";

    @Test
    void lawn_should_be_retrieved_from_file() {
        try {
            Lawn lawn = FileTranslator.translateFile(FILENAME, FILEPATH);
            Assertions.assertEquals(lawn, getExpectedLawn());
        } catch (IncorrectFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Lawn getExpectedLawn() {
        List<MowerInstruction> instruction1 = List.of(G, A, G, A, G, A, G, A, A);
        List<MowerInstruction> instruction2 = List.of(A, A, D, A, A, D, A, D, D, A);
        Mower mower1 = Mower.builder().id(0l).direction(MowerDirection.N).position(new Position(1, 2)).build();
        Mower mower2 = Mower.builder().id(1l).direction(MowerDirection.E).position(new Position(3, 3)).build();
        Map<Mower, List<MowerInstruction>> expectedInstructions = new LinkedHashMap<>();
        expectedInstructions.put(mower1, instruction1);
        expectedInstructions.put(mower2, instruction2);
        return Lawn.builder().topRightCorner(new Position(5, 5)).mowersInstructions(expectedInstructions).build();
    }
}

package com.mowitnow.kata;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.*;
import com.mowitnow.kata.service.MowerService;
import com.mowitnow.kata.service.MowerServiceMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepDefinitions {
    private final String FILEPATH = "src/test/resources/com/mowitnow/kata/in/";
    private String fileName;
    private Mower mower;
    private Lawn lawn = Lawn.builder().build();
    private final MowerService service = new MowerServiceMgr();
    private String output;
    private long idMower = 0;

    @Given("The following mower position : {int},{int},{}")
    public void theFollowingMowerPosition(int x, int y, String direction) {
        mower = Mower.builder()
                .id(idMower++)
                .position(new Position(x, y))
                .direction(MowerDirection.valueOf(direction))
                .build();
    }

    @Given("The following lawn coordinate : {int},{int}")
    public void theFollowingLawnCoordinate(int x, int y) {
        lawn = lawn.toBuilder()
                .topRightCorner(new Position(x, y))
                .build();
    }

    @When("I ask the mower to execute the instruction : {}")
    public void iAskTheMowerToExecuteTheInstruction(String instruction) {
        Map<Mower, List<MowerInstruction>> instructions = new HashMap<>();
        instructions.put(mower, List.of(MowerInstruction.valueOf(instruction)));
        service.executeInstruction(lawn.toBuilder().mowersInstructions(instructions).build());
    }

    @Then("The mower new position should be {int},{int},{}")
    public void theMowerNewPositionShouldBe(int x, int y, String direction) {
        Mower expected = mower.toBuilder()
                .position(new Position(x, y))
                .direction(MowerDirection.valueOf(direction))
                .build();
        Assertions.assertEquals(expected, mower);
    }


    @Given("I received the {} file")
    public void iReceivedTheCorrectFileTxtFile(String fileName) {
        this.fileName = fileName;
    }

    @When("I ask the mower handler to execute all instructions")
    public void iAskTheMowerToExecuteAllInstructions() {
        try {
            output = service.executeInstruction(fileName, FILEPATH);
        } catch (IncorrectFileException | IOException e) {
            output = "";
        }
    }

    @Then("An exception should be raised")
    public void aMissingInstructionExceptionShouldBeRaised() {
        Assertions.assertThrows(IncorrectFileException.class, () -> service.executeInstruction(fileName, FILEPATH));
    }

    @Then("Output should be {string}")
    public void outputShouldBe(String expected) {
        Assertions.assertEquals(expected, output);
    }
}
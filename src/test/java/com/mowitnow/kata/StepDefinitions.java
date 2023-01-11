package com.mowitnow.kata;

import com.mowitnow.kata.exception.IncorrectFileException;
import com.mowitnow.kata.model.*;
import com.mowitnow.kata.service.MowerService;
import com.mowitnow.kata.service.MowerServiceMgr;
import com.mowitnow.kata.util.FileTranslatorUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepDefinitions {

    private final String FILEPATH = "resources/com/mowitnow/kata/in";
    private String fileName;
    private Mower mower;
    private Lawn lawn;
    private MowerService service = new MowerServiceMgr();
    private String output;

    @Given("The following mower position : {int},{int},{}")
    public void theFollowingMowerPosition(int x, int y, String direction) {
        mower = Mower.builder()
                .position(new Position(x, y))
                .direction(MowerDirection.valueOf(direction))
                .build();
    }

    @And("The following lawn coordinate : {int},{int}")
    public void theFollowingLawnCoordinate(int x, int y) {
        lawn = Lawn.builder()
                .topRightCorner(new Position(x, y))
                .mowers(Arrays.asList(mower))
                .build();
    }

    @When("I ask the mower to execute the instruction : {}")
    public void iAskTheMowerToExecuteTheInstruction(String instruction) {
        mower = service.executeInstruction(mower, MowerInstruction.valueOf(instruction));
    }

    @Then("The mower new position should be {int},{int},{}")
    public void theMowerNewPositionShouldBe(int x, int y, String direction) {
        Mower expected = Mower.builder()
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
            output = service.executeInstructionsFile(fileName, FILEPATH);
        } catch (IncorrectFileException e) {
            output = "";
        }
    }

    @Then("An exception should be raised")
    public void aMissingInstructionExceptionShouldBeRaised() {
        Assertions.assertThrows(IncorrectFileException.class, () -> {
            service.executeInstructionsFile(fileName, FILEPATH);
        });
    }

    @Then("Output should be {string}")
    public void outputShouldBe(String expected) {
        Assertions.assertEquals(expected, output);
    }
}
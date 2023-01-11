package com.mowitnow.kata;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("The following mower position : {int},{int},{}")
    public void theFollowingMowerPosition(int arg0, int arg1, char arg3) {
    }

    @And("The following lawn coordinate : {int},{int}")
    public void theFollowingLawnCoordinate(int arg0, int arg1) {
    }

    @When("I ask the mower to execute the instruction : {}")
    public void iAskTheMowerToExecuteTheInstruction(char arg0) {
    }

    @Then("The mower new position should be {int},{int},{}")
    public void theMowerNewPositionShouldBe(int arg0, int arg1, char arg2) {
    }

    @Then("The mower should not change its position")
    public void theMowerShouldNotChangeItsPosition() {
    }

    @Given("I received the {} file")
    public void iReceivedTheCorrectFileTxtFile(String fileName) {
    }

    @When("I ask the mower handler to execute all instructions")
    public void iAskTheMowerToExecuteAllInstructions() {
    }

    @Then("An exception should be raised")
    public void aMissingInstructionExceptionShouldBeRaised() {
    }

    @Then("Output should be {string}")
    public void outputShouldBe(String arg0) {
    }
}
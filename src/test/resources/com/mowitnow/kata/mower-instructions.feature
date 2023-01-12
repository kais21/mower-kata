Feature: All mowers should execute sequentially all instructions
  and the mower handler should manage exceptions

  Scenario: Receiving a correct file
    Given I received the correctFile.txt file
    When I ask the mower handler to execute all instructions
    Then Output should be "1 3 N 5 1 E"

  Scenario: Receiving a file having a missing line instruction
    Given I received the missingInstructionLine.txt file
    When I ask the mower handler to execute all instructions
    Then An exception should be raised

  Scenario: Receiving a file having a wrong lawn coordinate
    Given I received the wrongLawnCoordinate.txt file
    When I ask the mower handler to execute all instructions
    Then An exception should be raised

  Scenario: Receiving a file having a wrong mower coordinate
    Given I received the wrongMowerCoordinate.txt file
    When I ask the mower handler to execute all instructions
    Then An exception should be raised

  Scenario: Receiving a file having an unknown instruction
    Given I received the wrongInstructions.txt file
    When I ask the mower handler to execute all instructions
    Then An exception should be raised
Feature: The mower should move forward if the next position is available
  and should not move in borders lines

  Scenario: The Mower in north position is executing a step forward
    Given The following mower position : 2,2,N
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 2,3,N

  Scenario: The Mower in south position is executing a step forward
    Given The following mower position : 2,2,S
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 2,1,S

  Scenario: The Mower in east position is executing a step forward
    Given The following mower position : 2,2,E
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 3,2,E

  Scenario: The Mower in west position is executing a step forward
    Given The following mower position : 2,2,W
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 1,2,W

  Scenario: The Mower in north border position is executing a step forward
    Given The following mower position : 2,5,N
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 2,5,N

  Scenario: The Mower in south border position is executing a step forward
    Given The following mower position : 2,0,S
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 2,0,S

  Scenario: The Mower in east position is executing a step forward
    Given The following mower position : 5,2,E
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 5,2,E

  Scenario: The Mower in west position is executing a step forward
    Given The following mower position : 0,2,W
    And The following lawn coordinate : 5,5
    When I ask the mower to execute the instruction : A
    Then The mower new position should be 0,2,W

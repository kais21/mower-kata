Feature: The mower should turn right and left correctly depending on its position

  Scenario: The Mower in north position is turning right
    Given The following mower position : 2,2,N
    When I ask the mower to execute the instruction : D
    Then The mower new position should be 2,2,E

  Scenario: The Mower in north position is turning left
    Given The following mower position : 2,2,N
    When I ask the mower to execute the instruction : G
    Then The mower new position should be 2,2,W

  Scenario: The Mower in east position is turning right
    Given The following mower position : 2,2,E
    When I ask the mower to execute the instruction : D
    Then The mower new position should be 2,2,S

  Scenario: The Mower in east position is turning left
    Given The following mower position : 2,2,E
    When I ask the mower to execute the instruction : G
    Then The mower new position should be 2,2,N

  Scenario: The Mower in south position is turning right
    Given The following mower position : 2,2,S
    When I ask the mower to execute the instruction : D
    Then The mower new position should be 2,2,W

  Scenario: The Mower in south position is turning left
    Given The following mower position : 2,2,S
    When I ask the mower to execute the instruction : G
    Then The mower new position should be 2,2,E

  Scenario: The Mower in west position is turning right
    Given The following mower position : 2,2,W
    When I ask the mower to execute the instruction : D
    Then The mower new position should be 2,2,N

  Scenario: The Mower in west position is turning left
    Given The following mower position : 2,2,W
    When I ask the mower to execute the instruction : G
    Then The mower new position should be 2,2,S



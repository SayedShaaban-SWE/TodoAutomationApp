Feature: As a user i need to add a task with a name and description.

  Scenario: Create task with valid name and description.
    Given The app is opened.
    When Click on add button.
    And Enter Task name.
    And Enter Task Description.
    And Click on save button.
    Then The Task will be created and saved.
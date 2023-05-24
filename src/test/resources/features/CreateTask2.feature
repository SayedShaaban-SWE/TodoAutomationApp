Feature: As a user i need to add a task with a name and description.

  Scenario Outline: Create task with valid name and description.
    Given The app is opened2.
    When Click on add button2.
    And Enter please1 "<TaskName>".
    And Enter please2 "<TaskDescription>".
    And Click on save button2.
    Then The Task will be created and saved2.
    Examples:
      | TaskName | TaskDescription|
      | sayed | heesaaaa          |
      | takkk | boooom            |



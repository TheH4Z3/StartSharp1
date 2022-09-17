#language: en
Feature: Create new meeting with new contact

  Scenario Outline: Tester wants create new meeting for new contact
    Given Tester opens the StartSharp login
    When Tester wants to loging, he types his credentials
      | user  | password |
      | admin | serenity |

    When Tester create new meeting with new contact

    Then Tester will be able see the meeting was succesfully scheduled <text2>
    Examples:
      | text2    |
      | 22768491 |

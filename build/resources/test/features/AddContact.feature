#language: en
Feature: Add contacts from Excel to contacts list


  Scenario Outline: Add Contact
    Given Tester opens the StartSharp login
    When Tester wants to loging, he types his credentials
      | user  | password |
      | admin | serenity |

    Then Tester can add a new contact to contacts list <text>

    Examples:
      | text     |
      | 22768491 |

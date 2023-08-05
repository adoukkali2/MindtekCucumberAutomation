@ui @regression
Feature: Validating Login Functionality

  @smoke @loginPositive @MB8-83
  Scenario: Validating login functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully logged in and lands on the homepage

  @smoke @loginNegative @MB8-83
  Scenario: Validating login functionality with invalid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "Tester"
    Then User validates error message "Invalid Login or Password."

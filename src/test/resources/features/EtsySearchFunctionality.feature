@regression @ui @etsy
Feature: Validating search functionality

#  Background will run steps below for each Scenario.
  Background: Repeated Steps/ Set up for Etsy tests
    Given User navigates to Etsy application
    When User searches for "carpet"

  @itemDescription
  Scenario: Validating search result matches the searched item
    Given User navigates to Etsy application
    When User searches for "carpet"
    Then User validates search result contains
      | carpet  | rug     |
      | turkish | persian |
#    The values above are in a DataTable format. @Then step will accept values that are below in pipes.

  @priceRange
  Scenario: Validating price range functionality for searched item
    And User selects price range over 1000
    Then user validates price range for items over 1000

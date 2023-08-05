@ui @WebOrdersOrderCreation @regression

Feature: Validating Order Creation

  Background:Logging in to Web Orders Application
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    And User clicks on Order tab

  Scenario Outline: Validating discount calculator
    When User selects product "<product>" and quantity <quantity>
    And User validates the price is correctly calculated for <quantity>
    Examples:
      | product     | quantity |
      | MyMoney     | 5        |
      | FamilyAlbum | 10       |
      | ScreenSaver | 15       |


  @placeOrder
  Scenario: Validating Order Creation Functionality
    And User created order with data
      | PRODUCT     | QUANTITY | CUSTOMER NAME | STREET      | CITY    | STATE         | ZIP   | CARD | CARD NUM  | EXP DATE |
      | ScreenSaver | 5        | Jane Doe      | 123 Lee St. | Boston  | Massachusetts | 12345 | Visa | 123456789 | 01/2025  |
      | MyMoney     | 10       | Harsh Patel   | 123 Abc St. | Chicago | Illinois      | 60656 | Visa | 123456789 | 01/2025  |
    Then User validates success message "New order has been successfully added."
    And User validates created order is in the list of all orders.



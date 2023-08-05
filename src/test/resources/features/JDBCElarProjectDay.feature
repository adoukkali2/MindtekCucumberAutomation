@jdbcYard
Feature: Validating added yard is persisted in Database

  Background:
    Given User navigates to Elar Logistics application
    When user logs in with username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks on Yards tab
    And User clicks on Add yard


  Scenario: Validating Yard is saved in UI and inserted correctly into table in Database(Required Fields)
    And User inputs required yard data
      | NAME   | STREET             | CITY        | STATE      | ZIP CODE | SPOTS |
      | QWERTY | 1224 W Addison St. | Los Angeles | California | 60656    | 11122 |
      | AWSerq | 1234 Abcd Blvd.    | Chicago     | Illinois   | 60631    | 2234  |
    And User clicks on add yard button
    Then User validates Yard is saved in application and Yard is correctly inserted into core_yard table in Database




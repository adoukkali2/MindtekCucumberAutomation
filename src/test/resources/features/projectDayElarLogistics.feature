@elarLogisticsButtons
Feature: Validating Elar Logistics Button Functionality

  Background:
    Given User navigates to Elar Logistics application
    When user logs in with username "student@mindtekbootcamp.com" and password "ilovejava"
    And User clicks on companies tab

  @validateIfEditable
  Scenario: Validation of editing input field
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    Then User validates fields are editable

  @cancelBtn
  Scenario: Validating company fields stay the same when user clicks on cancel button
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User clicks on cancel button
    Then User validates fields remain the same

  @elarWithData
  Scenario: Validating company name stays the same after edited and user clicks on cancel button (WIth test data)
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User clicks on company name and rename it
    And User clicks on cancel button
    Then  User validates edited fields remain the same

  @backToCompanies
  Scenario: Validate that list of companies is displayed when user clicks on "Back to companies" button
    And User selects "AAABBBCCC" company
    And User clicks back to companies button
    Then User validates list of companies is displayed


  @creationPageValidation
  Scenario: Validating company creation page when user clicks "Add Company" button
    And User clicks on Add company button
    Then User validates navigation to company creation page


  @cantBeEdited
  Scenario: Validating form can't be edited after clicking on cancel button
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User clicks on cancel button
    Then User Validates Company Name can't be cleared


  @editExisting
  Scenario: Validation of editing already existing companies
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    Then User validates existing companies are editable


  @fieldsImmutable
  Scenario: Validating values of the field are immutable after clicking cancel button
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User clicks on cancel button
    Then User Validates fields are immutable


  @validateSaveBtn
  Scenario: Validating input is saved after editing fields after clicking "Save" btn
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User clicks on company name and renames it
    And User clicks on save button
    And User clicks on Stay on current page when pop-up is visible
    Then User validates input is saved

  @successfulPopUpMessage
  Scenario: Validating Pop-Up says "Abc successfully changed" after user clicks on save button
    And User selects "AAABBBCCC" company
    And User clicks on edit button
    And User changes the MC Number
    And User clicks on save button
    Then User validates pop-up says AAABBBCCC successfully changed


    @popUpContainsName
    Scenario: Validate pop-up includes Company Name
      And User selects "AAABBBCCC" company
      And User clicks on edit button
      And User clicks on save button
      Then User validates pop-up includes company name













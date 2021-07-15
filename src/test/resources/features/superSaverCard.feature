@sanity2
Feature: New SS Flow

  Scenario: SS flow with active user
    Given I am logged in as "SS Active User" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Supersaver Card" card
    Then the Supersaver card subscription should be "Active"

  @ignore
  Scenario: SS flow with inactive user
    Given I am logged in as "SS Inactive User" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Supersaver Card" card
    Then the Supersaver card subscription should be "InActive"
#    failed with 500
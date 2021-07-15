@sanity2
Feature: Profile - KYC user

  Background: Start logging in
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on "Profile" on the footer

  Scenario: Set transaction limit for no KYC user
    When I tap Set Transaction Limit
    Then the Set up your Free Cashback Card screen should be opened

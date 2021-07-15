@sanity2
Feature: My Card - Full KYC

  Background: Start logging in
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on "My Card" on the footer

  Scenario: Activate New Digital Card
    When I tap Activate New Digital Card
    And I enter a PIN
    And I enter the PIN again
    Then the OTP Authentication page should be displayed

@WIP
Feature: Stocks

  Background: Start logging in
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Stocks" card

  Scenario: Open New Account to check redirection on On boarding UI
    When I click on 'Open New Account' button
    Then the "Welcome to dhani stocks" should be displayed
    And the url should contain with ""

  Scenario: Click on Back arrow from Stocks landing/Login screen to go back to Native app
    When I click on 'Open New Account' button
    And I click on Back arrow from Stock on boarding page
    And I click on 'Okay' alert button
    Then the Home button in the footer should be displayed

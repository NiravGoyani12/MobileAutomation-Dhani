@sanity2
Feature: Play Free Games

  Background: Start logging in
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the native "Play Free Games" card

  @smoke
  Scenario: Play 'Spin the Wheel'
    When I click on the "Spin The Wheel" game
    And I click on the Spin Now button
    And I click on the next Spin Now button
    And I wait until the wheel stops
    Then the "Spin daily to win" text should be visible

  Scenario: Play 'Basketball'
    When I click on the "Basketball" game
    And I tap continue to play basketball
    Then the url should contain with "basketball-game/start"

  Scenario: Play 'Dart Game'
    When I click on the "Dart Game" game
    And I tap Continue to play Dart
    Then the url should contain with "dart-game/start"

  Scenario: Play 'Pacman'
    When I click on the "Pacman" game
    And I tap Play button to go to Pacman
    And I tap on the next screen to start playing Pacman
    Then the url should contain with "pacman/play"

  Scenario: Play 'Dhani Pool'
    When I click on the "Dhani Pool" game
    And I tap Continue to play pool
    Then the url should contain with "pool-game/start/"

  Scenario: Play 'Paper Flick'
    When I click on the "Paper Flick" game
    And I tap on Play button to start Paper Flick game
    And I tap to start
    Then the url should contain with "paperflick/play"

  Scenario: Refer and Earn 'Generate referral link'
    When I click on the 'refer and earn' banner
    Then the "Set up your Free Cashback Card to continue" text should be visible in the No KYC "Dost" web card section

@sanity2
Feature: My Card

  Background: Start logging in
    Given I am logged in as "with card" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on "My Card" on the footer
    And I go through the demo

  @smoke
  Scenario: User with Existing Card
    Then my card with number "5085 5300 1001 8029" should be displayed

  Scenario: Lost Card
    When I tap Lost Card
    Then the Confirmation popup with title "Lost your DhaniPay Card? Block it now" should be displayed

  Scenario: Reset Transaction Pin
    When I tap Reset Transaction Pin
    Then the OTP Authentication page should be displayed

  Scenario: Transactions List
    Then the Transactions header should be displayed
    And the Transaction Date should be displayed
    And the Transaction Title should be displayed
    And the Transaction Amount should be displayed
    And the Transaction Details should be displayed

  Scenario: Activate Supersaver
    When I tap Activate Supersaver
    Then the Supersaver Details screen should be displayed
    When I tap Continue in the Supersaver Details screen
    Then the Choose Your Plan screen should be displayed
    When I tap Buy Now
    Then the supported banks section should be displayed

  Scenario: Set Transaction Limit
    When I tap Set Transaction Limit on My Card screen
    Then the Set Transaction Limit page should be opened
    When I enter the minimum amount per transaction 50000
    And I tap Save Changes
    Then the OTP Authentication page should be displayed
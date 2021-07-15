@sanity2
Feature: Profile

  Background: Start logging in
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on "Profile" on the footer

  @smoke
  Scenario: Set transaction limit
    When I tap Set Transaction Limit
    Then the Set Transaction Limit page should be opened
    When I enter the minimum amount per transaction 50000
    And I tap Save Changes
    Then the OTP Authentication page should be displayed

  Scenario Outline: Support with Full Kyc
    When I click "<label>" label on profile screen
    Then the "<text>" text is displayed for "<label>" screen

    Examples:
      | label                | text       |
      | FAQs & Customer Care | FAQs       |
      | Contact Us           | Contact Us |

  Scenario Outline: About Us with Full Kyc
    When I click "<label>" label on profile screen
    Then the "<text>" text is displayed for "<label>" screen

    Examples:
      | label              | text                 |
      | Terms & Conditions | Terms and Conditions |
      | Privacy Policy     | Privacy Policy       |

  Scenario: Upload profile picture with Full Kyc
    When I tab 'Add photo' icon
    And I tab 'Add photo' icon on edit profile
    Then the "Set your profile picture" text is displayed on edit profile

  Scenario: View Statement/Make Payment link with Full Kyc
    When I click "View Statement / Make Payments & Service Requests" label on profile screen
    Then the "Your Loan Summary" text is displayed for "View Statement / Make Payments & Service Requests" screen

  Scenario: My Saved Cards
    When I click "My Saved Cards" label on profile screen
    Then the Other Bank Cards screen should be displayed

  Scenario: Add Money
    When I click "Add Money" label on profile screen
    Then the Add Money screen should be displayed
    When I tap the 100 button
    And I tap the Add Money button
    Then the url should contain with "/?payData"
    Then the Pay Securely screen should be opened
    And it should contain the amount "100"

  Scenario: Transaction Statement
    When I click "Transaction Statement" label on profile screen
    Then the General Wallet Statement screen should be displayed
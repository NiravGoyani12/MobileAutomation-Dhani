@sanity1
Feature: Login
  As an end user
  I want to login
  So that I can explore dhani app

  Background:
    Given I click Start Now

  Scenario Outline: Log in as "<userType>" with valid credentials
    And I enter the mobile number of "<userType>" user
    And I tap on next to continue
    And I enter my password
    And I tap to continue
    And I click the Skip button on the Register page if it is displayed
    And I close the 'Offer of the day' pop up if it is displayed
    Then the Home button in the footer should be displayed

    Examples:
      | userType |
      | No KYC   |
      | Full KYC |

  Scenario: Click 'Need Help' on Mobile Number page
    When I click Need Help
    Then the text "Call us at below number" should be displayed

  Scenario: Click 'Need Help' on Password page
    And I enter the mobile number of "No KYC" user
    And I tap on next to continue
    When I click Need Help
    Then the text "Call us at below number" should be displayed

  Scenario: Click Forgot Password on Password page
    And I enter the mobile number of "No KYC" user
    And I tap on next to continue
    When I click Forgot Password
    Then the OTP Authentication page or 'You have crossed the maximum number of OTP retry allowed' text should be displayed

  @smoke
  Scenario: Log out
    And I enter the mobile number of "No KYC" user
    And I tap on next to continue
    And I enter my password
    And I tap to continue
    And I click the Skip button on the Register page if it is displayed
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on "Profile" on the footer
    Then the Profile page should be displayed
    When I click Log Out
    And I click Yes in the Confirmation popup
    Then the Password page should be displayed

  Scenario: Log in as different user
    And I enter the mobile number of "No KYC" user
    And I tap on next to continue
    When I click on the 'Log in as different user' link
    Then I enter the mobile number of "Min KYC" user
    And I tap on next to continue
    And I enter my password
    And I tap to continue
    And I click the Skip button on the Register page if it is displayed
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed

  Scenario:Set Password Screen - Check Terms and condition link
    And I enter the mobile number of "New User" user
    When I tap on next to continue
    Then the 'Terms & Conditions' link should be displayed

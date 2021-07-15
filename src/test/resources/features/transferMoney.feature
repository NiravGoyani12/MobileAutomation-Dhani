@sanity2
Feature: Transfer Money

  Background: Start logging in
    Given I am logged in as "Add Bank Money User" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the native "Transfer Money" card

  Scenario: Add Bank Account
    When I click on Transfer to Bank
    And I click on Add a Bank Account
    And I enter following details to create  saving Account
      | Name | Number     | Code        |
      | Cust | 9898989848 | ICIC0000986 |
    And I press Add account button
    Then the Success title for "Add bank" with "Yay! Your Bank account has been added successfully" should be displayed
    And I remove Added Bank Account

  Scenario: Transfer money to Bank Account
    When I click on Transfer to Bank
    And I select  Account to transfer money
    And I enter "1" amount that needs to be transferred to beneficiary
    And I press continue button
    And I click Transfer button
    Then the Success title for "Transfer money to bank" with "Transaction successful" should be displayed

  Scenario: Send Money
    When I click on Send Money section
    And I enter "4000000001" mobile number of recipient
    And I enter "1" amount that needs to be transferred to receiver
    And I enter thank you message as "Thank you for your help"
    And I press Send Money Button
    Then the Success title for "Send money" with "Yay! You just made someone's day!" should be displayed

  Scenario: Request Money
    When I click on request money
    And I enter "4000000001" mobile number of requester
    And I enter "1" amount that needs to be transferred from requester
    And I enter requesting  message as "Can you please transfer money"
    And I press Request Money Button
    Then the Success title for "Request money" with "Yay! Your request for cash was a success" should be displayed

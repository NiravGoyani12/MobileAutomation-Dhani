@WIP
Feature: Health Care

  Scenario: Validate that link "Essential Vitamins Kit" can be opened for No kyc
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Covid Care Health Kit" card
    Then I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."

  Scenario: Validate that link "Essential Vitamins Kit" can be opened for Min kyc
    Given I am logged in as "Min KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Covid Care Health Kit" card
    Then I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."

  Scenario: Validate that link "Essential Vitamins Kit" can be opened for Min kyc
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Covid Care Health Kit" card
    Then I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."

  Scenario: Validate the Order Now button on health-bag page
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Covid Care Health Kit" card
    When I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."
    Then I click on Order Now Button

  Scenario: Validate the Add address page has sections Invoice and Delivery address
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Covid Care Health Kit" card
    And I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."
    And I click on Order Now Button
    And I click on next button
    And I should see payment confirmation popup displaying "Net Payable Amount"
    When I click on Pay button
    Then I should see Pay Securely Page for Payment using variety of payment methods

  Scenario: Validate that pop-up appears on clicking Next button on Add adress page.
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Covid Care Health Kit" card
    And I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."
    And I click on Order Now Button
    And I click on next button
    And I should see payment confirmation popup displaying "Net Payable Amount"
    And I click on Pay button
    When I should see Pay Securely Page for Payment using variety of payment methods
    Then I can select payment method as CreditCard


  Scenario: Validate that clicking on Pay button on pop-up Pay Securely web page is fetched.
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Covid Care Health Kit" card
    And I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."
    And I click on Order Now Button
    And I click on next button
    And I should see payment confirmation popup displaying "Net Payable Amount"
    And I click on Pay button
    When I should see Pay Securely Page for Payment using variety of payment methods
    Then I can select payment method as CreditCard

  Scenario: Validate the Confirmation pop-up of selecting the mode of payment.
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Covid Care Health Kit" card
    And I should see Order Confirmation Page Displaying "Your Free Essential Vitamins Kit contains 1 month course of vitamins & zinc for two people."
    And I click on Order Now Button
    And I click on next button
    And I should see payment confirmation popup displaying "Net Payable Amount"
    And I click on Pay button
    And I should see Pay Securely Page for Payment using variety of payment methods
    And I can select payment method as CreditCard
    And I enter payment details for Credit Card
    When I press Pay by Credit Card button
    Then I should see order successful message

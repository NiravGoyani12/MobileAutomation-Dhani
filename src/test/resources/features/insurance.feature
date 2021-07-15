@sanity2
Feature: Insurance

Background: Log in
  Given I am logged in as "Full KYC" user
  And I close the 'Offer of the day' pop up if it is displayed
  And the Home button in the footer should be displayed

Scenario: New Insurance
  When I click on the web "Insurance" card
  Then the "Insurance" text should be visible in the full KYC "Insurance" web card section
  When I tap Get Insured Now button
  And I tap Avail Now
  Then the Sum Insured screen should open

@WIP
Feature: Mobile Recharge

  Scenario: Mobile recharge for prepaid number
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the native "Mobile Recharge" card
#    When I Enter "9725265075" Mobile number for recharge
#    And I select an operator "Airtel"
#    And I select the area "Gujarat"
#    And I enter mobile recharge amount "11"
#    And I click on 'RECHARGE' button
#    Then the "Order Summary" page should be displayed

@sanity1
Feature: Native cards

  Scenario Outline: No KYC user opens "<cardName>" native card
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the native "<cardName>" card
    Then the "<text>" text should be visible on the No KYC "<cardName>" card

    Examples:
      | cardName        | text                                       |
      | Play Free Games | Earn Rewards                               |
#      | Mobile Recharge | Set up your Free Cashback Card to continue |
      | Shopping        | Shopping                                   |
      | Transfer Money  | Set up your Free Cashback Card to continue |

  Scenario Outline: Full KYC user opens "<cardName>" native card
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the native "<cardName>" card
    Then the "<text>" text should be visible on the Full KYC "<cardName>" card

    Examples:
      | cardName        | text               |
      | Play Free Games | Dhani Cash Balance |
#      | Mobile Recharge | Current Balance    |
      | Shopping        | Shopping           |
      | Transfer Money  | Transfer Money     |

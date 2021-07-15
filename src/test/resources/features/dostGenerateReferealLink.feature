@sanity1
Feature: Refer  and Earn - Generate Referral link

  Scenario Outline: Generate Referral link
    Given I am logged in as "with card" user
    And I close the 'Offer of the day' pop up if it is displayed
    And I click on the web "Dost" card
    When I tab 'Refer Now' icon
    And I tab 'Refer Now' icon to recommend "<cardType>" card
    Then the "<referralLinkText>" referral link should be generated for "<cardType>" card

    Examples:
      | cardType           | referralLinkText                                                      |
      | Free Cashback Card | I am using dhani free cashback card and you should also try this card |
      | Dhani One Freedom  | Try dhani One Freedom card which gives a credit limit of up           |
      | Dhani Super Saver  | Hey - I am using dhani the super saver card and you should also try   |
      | Dhani Doctor       | Hey - I am using dhani doctor and you should also try using this      |
      | Dhani Pharmacy     | I am using dhani epharmacy and you should also try using this service |

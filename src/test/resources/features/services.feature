@sanity2
Feature: Services

  Scenario Outline:Open "<service>" service with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    And I click on "Services" on the footer
    When I click on "<service>" service tile
    Then the "<text>" text is displayed on "<service>" service screen with "<userType>"

    Examples:
      | service        | userType | text                                       |
      | Mobile         | No KYC   | Set up your Free Cashback Card to continue |
      | Mobile         | Full KYC | Select Operator                            |
      | DTH            | No KYC   | Set up your Free Cashback Card to continue |
      | DTH            | Full KYC | Select Operator                            |
      | Datacard       | No KYC   | Set up your Free Cashback Card to continue |
      | Datacard       | Full KYC | Select Operator                            |
      | Electricity    | No KYC   | Set up your Free Cashback Card to continue |
      | Electricity    | Full KYC | Select Operator                            |
      | Gas            | No KYC   | Set up your Free Cashback Card to continue |
      | Gas            | Full KYC | Select Operator                            |
      | Landline       | No KYC   | Set up your Free Cashback Card to continue |
      | Landline       | Full KYC | Select Operator                            |
      | Broadband      | No KYC   | Set up your Free Cashback Card to continue |
      | Broadband      | Full KYC | Select Operator                            |
      | Water          | No KYC   | Set up your Free Cashback Card to continue |
      | Water          | Full KYC | Select Operator                            |
      | LPG            | No KYC   | Set up your Free Cashback Card to continue |
      | LPG            | Full KYC | Select Operator                            |
      | Cable TV       | No KYC   | Set up your Free Cashback Card to continue |
      | Cable TV       | Full KYC | Select Operator                            |
      | Life Insurance | No KYC   | Set up your Free Cashback Card to continue |
      | Life Insurance | Full KYC | Select Operator                            |
      | FASTag         | No KYC   | Set up your Free Cashback Card to continue |
      | FASTag         | Full KYC | Select Operator                            |

@sanity1
Feature: Web cards

#  No KYC
  Scenario Outline: Open web card '<cardName>' for No KYC user
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "<cardName>" card
    Then the "<text>" text should be visible in the No KYC "<cardName>" web card section
    And the url should contain with "<url>"

    Examples:
      | cardName              | text                                                               | url                              |
      | Free Cashback Card    | Free Cashback Card                                                 | services/free-cashback           |
      | Stocks                | Welcome to                                                         | dhanistocks.com/welcome          |
      | Pharmacy              | Upload Prescription                                                | pharmacy.dhani.com/              |
      | Video Call a Doctor   | Meet our team of                                                   | dhaniDoctor/patient/welcome/main |
      | Covid Care Health Kit | Your Free Essential Vitamins Kit contains 1 month                  | dhaniDoctor/patient/health-bag   |
      | Supersaver Card       | Enjoy Flat 5% Instant Cashback on everything!                      | /services/super-saver/cashback   |
      | Free Health Card      | Free Health Card                                                   | services/health-card             |
      | Dhani Zone            | Choose from our handpicked collection to get you in the best mood. | /dhani                           |
#     FAILED with 500    | OneFreedom Credit     | Freedom from health worries, Freedom from interest                              | services/credit-line/top-benefits             |
#     FAILED with 500   | Credit Line           | No-EMI Personal Loan                                                            | cash-less-credit/dhani-care-loan/top-benefits |

  Scenario Outline: Open native web card '<cardName>' for No KYC user
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "<cardName>" card
    Then the "<text>" text should be visible in the No KYC "<cardName>" web card section

    Examples:
      | cardName  | text                                       |
      | Insurance | Set up your Free Cashback Card to continue |
      | Dost      | Set up your Free Cashback Card to continue |
   #  FAILED with 500   | Private Patient | Set up your Free Cashback Card to continue |

  Scenario: Open card 'Health 365' for No KYC user
    Given I am logged in as "No KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Health 365" card
    And I close 'Advertise' popup on health 365 card
    And I enter the pin code "201009"
    Then the "Free Doctor Consultation 24*7 & Free medicines for you & your partner" text should be visible in the No KYC "Health 365" web card section
    And the url should contain with "dhaniDoctor/patient/health365-select-plans"

#    Full KYC
  Scenario Outline: Open web card '<cardName>' for Full KYC user
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "<cardName>" card
    Then the "<text>" text should be visible in the full KYC "<cardName>" web card section
    And the url should contain with "<url>"

    Examples:
      | cardName              | text                                                               | url                                 |
      | Stocks                | Welcome to                                                         | dhanistocks.com/welcome             |
      | Pharmacy              | Upload Prescription                                                | pharmacy.dhani.com/                 |
      | Video Call a Doctor   | Choose a Plan                                                      | dhaniDoctor/patient/select-plans    |
      | Covid Care Health Kit | Recommend this Kit to your friends                                 | dhaniDoctor/patient/health-bag      |
      | Supersaver Card       | Enjoy Flat 5% Instant Cashback on everything!                      | /services/super-saver/cashback      |
      | Dhani Zone            | Choose from our handpicked collection to get you in the best mood. | /dhani                              |
      | Insurance             | Insurance                                                          | dhaniDoctor/patient/insurance       |
      | Dost                  | dhani dost                                                         | patient/dhani-dost/referral-program |
  # FAILED with 500      | OneFreedom Credit   | Freedom from health worries, Freedom from interest | services/credit-line/top-benefits |
  # FAILED with 500      | Credit Line           | No-EMI Personal Loan                                                            |cash-less-credit/dhani-care-loan/top-benefits|
  #  FAILED with 500  | Private Patient       | Private Patient                                                                 | dhaniDoctor/patient/family-doctors/unavailable |

  Scenario Outline: Open native web card '<cardName>' for Full KYC user
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "<cardName>" card
    Then the "<text>" text should be visible in the full KYC "<cardName>" web card section

    Examples:
      | cardName           | text    |
      | Free Cashback Card | My Card |
      | Free Health Card   | My Card |

  @smoke
  Scenario: Open card 'Health 365' for Full KYC user
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Health 365" card
    And I close 'Advertise' popup on health 365 card
    And I enter the pin code "201009"
    Then the "Free Doctor Consultation 24*7 & Free medicines for you & your partner" text should be visible in the full KYC "Health 365" web card section
    And the url should contain with "dhaniDoctor/patient/health365-select-plans"

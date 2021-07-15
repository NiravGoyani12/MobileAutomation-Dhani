@sanity1
Feature: Home screen

  @ignore
#    The Offer of the Day popup is removed in Production
#    Let's keep the test disabled in case we will need it again in the future
  Scenario Outline: Offer Of the day - Claim Now with "<userType>"
    Given I am logged in as "<userType>" user
    When I click on 'Offer Of Day - Claim Now'
    Then the url should contain with "scratch-card/view/"

    Examples:
      | userType |
      | No KYC   |
      | Full KYC |

  Scenario Outline: Notification Bell with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on Notification Bell
    Then the App Inbox should be displayed

    Examples:
      | userType |
      | No KYC   |
      | Full KYC |

  Scenario Outline: Support Icon with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on Support Icon
    Then the Support Categories page should be displayed

    Examples:
      | userType |
      | No KYC   |
      | Full KYC |

  Scenario Outline: Shopping with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on "Shopping" on the footer
    Then the "<text>" text is displayed on "Shopping" screen with "<userType>"

    Examples:
      | userType | text     |
      | No KYC   | Shopping |
      | Full KYC | Shopping |

  Scenario Outline: My Card with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on "My Card" on the footer
    Then the "<text>" text is displayed on "My Card" screen with "<userType>"

    Examples:
      | userType | text          |
      | No KYC   | Activate Card |
      | Full KYC | My Card       |

  @smoke
  Scenario Outline: Services with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on "Services" on the footer
    Then the "<text>" text is displayed on "Services" screen with "<userType>"

    Examples:
      | userType | text          |
      | No KYC   | Services      |
      | Full KYC | Available Now |

  Scenario Outline: Profile with "<userType>"
    Given I am logged in as "<userType>" user
    And I close the 'Offer of the day' pop up if it is displayed
    And the Home button in the footer should be displayed
    When I click on "Profile" on the footer
    Then the "<text>" text is displayed on "Profile" screen with "<userType>"

    Examples:
      | userType | text             |
      | No KYC   | Status: No KYC   |
      | Full KYC | Status: Full KYC |

  Scenario: Add Money On Balance section
    Given I am logged in as "Full KYC" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click "Add" label on home screen
    Then the Add Money screen should be displayed
    When I tap the 100 button
    And I tap the Add Money button
    Then the url should contain with "/?payData"

  Scenario: Inactive On Balance section for SS Inactive user
    Given I am logged in as "SS Inactive User" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click "Inactive" label on home screen
    Then the url should contain with "/services/credit-line"

  Scenario: Available credit limit for SS Inactive user
    Given I am logged in as "SS Inactive User" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click "Available Credit Limit" label on home screen
    Then the url should contain with "/credit-line/subscription-details"

  Scenario: FCC - Existing Active User without Card
    Given I am logged in as "Existing Active User without Card" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Free Cashback Card" card
    Then the Activate New Digital Card button on the My Card screen should be displayed

  Scenario: FHC - Existing Active User without Card
    Given I am logged in as "Existing Active User without Card" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Free Health Card" card
    Then the Get It For Free button on the Free Health Card should be displayed

  Scenario: FCC - Existing Active User with Card
    Given I am logged in as "Existing Active User with Card" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Free Cashback Card" card
    Then my card with number "6083 5300 1001 5660" should be displayed

    @ignore
#      The user already activated the "Free Health Card" card
#      And the test fails
#      We need either reset the card for the user or have another user
  Scenario: FHC - Existing Active User with Card
    Given I am logged in as "Existing Active User with Card" user
    And I close the 'Offer of the day' pop up if it is displayed
    When I click on the web "Free Health Card" card
    Then the Get It For Free button on the Free Health Card should be displayed
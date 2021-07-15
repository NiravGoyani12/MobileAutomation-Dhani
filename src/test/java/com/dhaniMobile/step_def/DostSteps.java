package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.webCards.DhaniDostCardScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DostSteps extends TestBase {

    DhaniDostCardScreen dhaniDostCardScreen = new DhaniDostCardScreen(driver);

    @When("I tab 'Refer Now' icon")
    public void iTabReferNowIcon() {
        dhaniDostCardScreen.clickOnReferNowIcon();
    }

    @And("^I tab 'Refer Now' icon to recommend \"([^\"]*)\" card$")
    public void iTabReferNowIconToRecommendCard(String cardType) {
        dhaniDostCardScreen.clickOnReferNowForCard(cardType);
        sleep(500);
    }

    @Then("^the \"([^\"]*)\" referral link should be generated for \"([^\"]*)\" card$")
    public void theReferralLinkShouldBeGeneratedForCard(String referralLinkText, String cardType) {

        String actTextInCardSection = "";
        switch(cardType.toLowerCase(Locale.ROOT)) {

            case "free cashback card":
                actTextInCardSection = dhaniDostCardScreen.getRefferalLinkText();
                break;
            case "dhani one freedom":
                actTextInCardSection = dhaniDostCardScreen.getRefferalLinkText();
                break;
            case "dhani super saver":
                actTextInCardSection = dhaniDostCardScreen.getRefferalLinkText();
                break;
            case "dhani doctor":
                actTextInCardSection = dhaniDostCardScreen.getRefferalLinkText();
                break;
            case "dhani pharmacy":
                actTextInCardSection = dhaniDostCardScreen.getRefferalLinkText();
                break;
            default:
                throw new IllegalStateException("Unexpected refer now icon: " + cardType.toLowerCase(Locale.ROOT));
        }
        assertThat(actTextInCardSection, containsString(referralLinkText));
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.TransferMoneyScreen;
import com.dhaniMobile.screens.nativeCards.MobileRechargeScreen;
import com.dhaniMobile.screens.nativeCards.ShoppingCardScreen;
import com.dhaniMobile.screens.nativeCards.PlayCardScreen;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class
NativeCardsSteps extends TestBase {

    PlayCardScreen playCardScreen = new PlayCardScreen(driver);
    MobileRechargeScreen mobileRechargeScreen = new MobileRechargeScreen(driver);
    ShoppingCardScreen shoppingCardScreen  = new ShoppingCardScreen(driver);
    TransferMoneyScreen transferMoneyScreen  = new TransferMoneyScreen(driver);

    @Then("^the \"([^\"]*)\" text should be visible on the No KYC \"([^\"]*)\" card$")
    public void text_should_be_visible_on_no_kyc_card(String cardText, String cardName) {
         String actTextInCardSection = "";

        switch(cardName.toLowerCase()) {

            case "play free games":
                actTextInCardSection = playCardScreen.getNoKycCardDescription();
                break;
            case "mobile recharge":
                actTextInCardSection = mobileRechargeScreen.getNoKycCardDescription();
                break;
            case "shopping":
                actTextInCardSection = shoppingCardScreen.getNoKycCardDescription();
                break;
            case "transfer money":
                actTextInCardSection = transferMoneyScreen.getNoKycCardDescription();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase());
        }

        assertThat(actTextInCardSection, containsString(cardText));
    }

    @Then("^the \"([^\"]*)\" text should be visible on the Full KYC \"([^\"]*)\" card$")
    public void text_should_be_visible_on_full_kyc_card(String cardText, String cardName) {
         String actTextInCardSection = "";

        switch(cardName.toLowerCase()) {

            case "play free games":
                actTextInCardSection = playCardScreen.getFullKycCardDescription();
                break;
            case "mobile recharge":
                actTextInCardSection = mobileRechargeScreen.getFullKycCardDescription();
                break;
            case "shopping":
                actTextInCardSection = shoppingCardScreen.getFullKycCardDescription();
                break;
            case "transfer money":
                actTextInCardSection = transferMoneyScreen.getFullKycCardDescription();
                break;
            default:
                throw new IllegalStateException("Unexpected card name: " + cardName.toLowerCase());
        }

        assertThat(actTextInCardSection, containsString(cardText));
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.MyCardScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyCardSteps extends TestBase {

    MyCardScreen myCardScreen = new MyCardScreen(driver);
    private String _pin;

    @Then("my card with number {string} should be displayed")
    public void myCardWithNumberShouldBeDisplayed(String cardNumber) {
       assertThat(myCardScreen.isCardWithNumberDisplayed(cardNumber), is(true));
    }

    @When("I tap Lost Card")
    public void iTapLostCard() {
        myCardScreen.tapLostCard();
    }

    @Then("the Confirmation popup with title {string} should be displayed")
    public void theConfirmationPopupWithTitleIsDisplayed(String text) {
       assertThat(myCardScreen.isConfirmationPopupDisplayed(text), is(true));
    }

    @And("I go through the demo")
    public void iGoThroughTheDemo() {
        myCardScreen.goThroughDemo();
    }

    @When("I tap Reset Transaction Pin")
    public void iTapResetTransactionPin() {
        myCardScreen.tapResetTransactionPin();
    }

    @Then("the Transactions header should be displayed")
    public void theTransactionsSectionShouldBeDisplayed() {
        assertThat(myCardScreen.isTransactionsHeaderDisplayed(), is(true));
    }

    @And("the Transaction Date should be displayed")
    public void theTransactionDateShouldBeDisplayed() {
        assertThat(myCardScreen.isTransactionDateDisplayed(), is(true));
    }

    @And("the Transaction Title should be displayed")
    public void theTransactionTitleShouldBeDisplayed() {
        assertThat(myCardScreen.isTransactionTitleDisplayed(), is(true));
    }

    @And("the Transaction Amount should be displayed")
    public void theTransactionAmountShouldBeDisplayed() {
        assertThat(myCardScreen.isTransactionAmountDisplayed(), is(true));
    }

    @And("the Transaction Details should be displayed")
    public void theTransactionDetailsShouldBeDisplayed() {
        assertThat(myCardScreen.isTransactionDetailsDisplayed(), is(true));
    }

    @When("I tap Activate Supersaver")
    public void iTapActivateSupersaver() {
        myCardScreen.tapActivateSuperSaver();
    }

    @Then("the Supersaver Details screen should be displayed")
    public void theSupersaverDetailsScreenShouldBeDisplayed() {
       assertThat(myCardScreen.isSupersaverScreenDisplayed(), is(true));
    }

    @When("I tap Continue in the Supersaver Details screen")
    public void iTapContinueInTheSupersaverDetailsScreen() {
        myCardScreen.tapContinueOnSupersaverDetailsScreen();
    }

    @Then("the Choose Your Plan screen should be displayed")
    public void theChooseYourPlanScreenShouldBeDisplayed() {
        assertThat(myCardScreen.isChooseYourPlanScreenDisplayed(), is(true));
    }

    @When("I tap Buy Now")
    public void iTapBuyNow() {
        myCardScreen.tapBuyNowOnChooseYourPlanScreen();
    }

    @Then("the supported banks section should be displayed")
    public void theSubscriptionChargesScreenShouldBeDisplayed() {
       assertThat(myCardScreen.isSupportedBanksSectionDisplayed(), is(true));
    }

    @When("I tap Set Transaction Limit on My Card screen")
    public void iTapSetTransactionLimitOnMyCardScreen() {
        myCardScreen.tapSetTransactionLimit();
    }

    @When("I tap Activate New Digital Card")
    public void iTapActivateNewDigitalCard() {
        myCardScreen.tapActivateNewDigitalCard();
    }

    @Then("the Activate New Digital Card button on the My Card screen should be displayed")
    public void activateNewDigitalCardButtonShouldBeDisplayed() {
       assertThat(myCardScreen.isActivateNewDigitalCardBtnDisplayed(), is(true));
    }

    @Then("the Activate New Digital Card button on the My Card screen should not be displayed")
    public void activateNewDigitalCardButtonShouldNotBeDisplayed() {
       assertThat(myCardScreen.isActivateNewDigitalCardBtnDisplayed(), is(false));
    }

    @And("I enter a PIN")
    public void iEnterPIN() {
        _pin = "1234";
        myCardScreen.enterPin(_pin);
    }

    @And("I enter the PIN again")
    public void iEnterThePINAgain() {
        myCardScreen.enterPin(_pin);
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.webCards.CovidCareCardScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CovidCareSteps extends TestBase {

    CovidCareCardScreen covidCareCardScreen = new CovidCareCardScreen(driver);

    @And("I click on Order Now Button")
    public void iClickOnOrderNowButton() {
        covidCareCardScreen.clickOnOrderNowButton();
    }

    @And("I click on next button")
    public void iClickOnNextButton() {
        covidCareCardScreen.clickOnNextButton();
    }

    @When("I click on Pay button")
    public void iClickOnPayButton() {
        covidCareCardScreen.clickOnPayButton();
    }

    @Then("I should see Pay Securely Page for Payment using variety of payment methods")
    public void iShouldSeePaySecurelyPageForPaymentUsingVarietyOfPaymentMethods() {
    }

    @And("I should see Order Confirmation Page Displaying {string}")
    public void iShouldSeeOrderConfirmationPageDisplaying(String expText) {
        assertThat(covidCareCardScreen.getDisplayedOrderConfirmationDetails(), containsString(expText));
    }

    @And("I should see payment confirmation popup displaying {string}")
    public void iShouldSeePaymentConfirmationPopupDisplaying(String expText) {
        assertThat(covidCareCardScreen.getDisplayedPaymentConfirmationDetails(), containsString(expText));
    }

    @Then("I should see Payment Successful message")
    public void iShouldSeePaymentSuccessfulMessage() {

    }

    @And("I enter payment details for Credit Card")
    public void iEnterPaymentDetailsForCreditCard() {
        covidCareCardScreen.enterCreditCardDetails();
    }

    @Then("I should see order successful message")
    public void iShouldSeeOrderSuccessfulMessage() {
        covidCareCardScreen.shouldseeOrderSuccessfulMessage();
    }

    @When("I press Pay by Credit Card button")
    public void iPressPayByCreditCardButton() {
        covidCareCardScreen.payByCreditCardButton();
    }

    @And("I can select payment method as CreditCard")
    public void iSelectPaymentMethodAsCreditCard() {
        covidCareCardScreen.selectPaymentMethodAsCreditCard();
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.webCards.StocksCardScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class StockSteps extends TestBase {

    StocksCardScreen stocksCardScreen = new StocksCardScreen(driver);

    @When("I click on 'Open New Account' button")
    public void iClickOnOpenNewAccountButton() {
        stocksCardScreen.clickOnOpenNewAccount();
    }

    @Then("the {string} should be displayed")
    public void theShouldBeDisplayed(String expText) {
        assertThat(stocksCardScreen.getWelcomeTextStock(), containsString(expText));
    }

    @And("I click on Back arrow from Stock on boarding page")
    public void iClickOnBackArrowFromStocksLanding() {
        stocksCardScreen.clickOnBackArrowOnStock();
    }

    @And("I click on 'Okay' alert button")
    public void iClickOnOkayAlertButton() {
        stocksCardScreen.clickOnOkayAlert();
    }
}

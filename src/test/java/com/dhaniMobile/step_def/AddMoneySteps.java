package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.AddMoneyScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddMoneySteps extends TestBase {
    AddMoneyScreen addMoneyScreen = new AddMoneyScreen(driver);

    @Then("the Add Money screen should be displayed")
    public void theAddMoneyScreenShouldBeDisplayed() {
        assertThat(addMoneyScreen.isDisplayed(), is(true));
    }

    @When("I tap the 100 button")
    public void iTapTheButton() {
        addMoneyScreen.tap100AmountBtn();
    }

    @And("I tap the Add Money button")
    public void iTapTheAddMoneyButton() {
        addMoneyScreen.tapAddMoneyBtn();
    }
}

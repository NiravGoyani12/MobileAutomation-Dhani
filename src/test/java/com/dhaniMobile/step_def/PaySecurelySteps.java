package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.PaySecurelyScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PaySecurelySteps extends TestBase {

    PaySecurelyScreen paySecurelyScreen = new PaySecurelyScreen(driver);

    @Then("the Pay Securely screen should be opened")
    public void thePaySecurelyScreenShouldBeOpened() {
        assertThat(paySecurelyScreen.isDisplayed(), is(true));
    }

    @And("it should contain the amount {string}")
    public void itShouldContainTheAmount(String amount) {
        assertThat(paySecurelyScreen.displaysAmount(amount), is(true));
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.webCards.SuperSaverScreen;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SuperSaverSteps extends TestBase {

    SuperSaverScreen superSaverScreen = new SuperSaverScreen(driver);

    @Then("the Supersaver card subscription should be {string}")
    public void theSupersaverCardSubscriptionShouldBe(String expText) {
        assertThat(superSaverScreen.getActiveSSText(), containsString(expText));
    }
}

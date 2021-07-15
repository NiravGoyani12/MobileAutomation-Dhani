package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.SpinTheWheel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SpinTheWheelSteps extends TestBase {

    SpinTheWheel spinTheWheel = new SpinTheWheel(driver);

    @When("^I click on the Spin Now button$")
    public void iClickOnSpinNow() {
        spinTheWheel.clickSpinNow();
    }

    @And("I click on the next Spin Now button")
    public void weClickOnTheSecondSpinNowButton() {
        spinTheWheel.clickSecondSpinNow();
    }

    @And("I wait until the wheel stops")
    public void iWaitUntilWheelStops() {
        spinTheWheel.waitUntilWheelStopped();
    }

    @Then("the {string} text should be visible")
    public void textIsVisible(String text) {
        assertThat(spinTheWheel.getTextForBasketball(), containsString(text));
    }
}

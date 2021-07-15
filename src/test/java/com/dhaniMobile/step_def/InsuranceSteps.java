package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.InsuranceScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InsuranceSteps extends TestBase {
    InsuranceScreen insuranceScreen = new InsuranceScreen(driver);

    @When("I tap Get Insured Now button")
    public void iTapGetInsuredNowButton() {
        insuranceScreen.tapGetInsuredNow();
    }

    @And("I tap Avail Now")
    public void iTapAvailNow() {
        insuranceScreen.tapAvailNow();
    }

    @Then("the Sum Insured screen should open")
    public void theMedicalInsuranceCoverScreenShouldOpen() {
        assertThat(insuranceScreen.isSumInsuredDisplayed(), is(true));
    }
}

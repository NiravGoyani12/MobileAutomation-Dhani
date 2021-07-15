package com.dhaniMobile.step_def.profile;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.profile.SetTransactionLimitScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SetTransactionLimitSteps extends TestBase {
    SetTransactionLimitScreen setTransactionLimitScreen = new SetTransactionLimitScreen(driver);

    @Then("the Set Transaction Limit page should be opened")
    public void theSetTransactionLimitPageShouldBeOpened() {
        assertThat(setTransactionLimitScreen.isDisplayed(), is(true));
    }

    @When("I enter the minimum amount per transaction {int}")
    public void enterMinAmountPerTransaction(int limit) {
        setTransactionLimitScreen.enterMinAmountPerTransaction(limit);
    }

    @And("I tap Save Changes")
    public void iTapSaveChanges() {
        setTransactionLimitScreen.tanConfirmChange();
    }
}

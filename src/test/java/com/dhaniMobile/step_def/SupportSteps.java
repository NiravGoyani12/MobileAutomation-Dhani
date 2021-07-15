package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.profile.SupportScreen;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SupportSteps extends TestBase {

    SupportScreen supportScreen = new SupportScreen(driver);

    @Then("the Support Categories page should be displayed")
    public void supportCategoriesShouldBeDisplayed() {
        assertThat(supportScreen.IsDisplayed(), is(true));
    }
}

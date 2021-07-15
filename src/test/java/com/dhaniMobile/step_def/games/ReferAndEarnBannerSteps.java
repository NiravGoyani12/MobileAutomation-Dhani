package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.ReferAndEarnBannerScreen;
import io.cucumber.java.en.When;

public class ReferAndEarnBannerSteps extends TestBase {

    ReferAndEarnBannerScreen referAndEarnBannerScreen= new ReferAndEarnBannerScreen(driver);

    @When("I click on the 'refer and earn' banner")
    public void iClickOnTheReferAndEarnBanner() {
        referAndEarnBannerScreen.clickOnTheReferAndEarnBanner();
    }
}

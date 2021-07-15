package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.Basketball;
import io.cucumber.java.en.And;

public class BasketballSteps extends TestBase {

    Basketball basketball = new Basketball(driver);

    @And("I tap continue to play basketball")
    public void tap_continue_play_basketball() {
        basketball.clickOnContinueBtn();
        sleep(10000);
    }
}

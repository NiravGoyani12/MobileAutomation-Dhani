package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.Pool;
import io.cucumber.java.en.And;

public class PoolSteps extends TestBase {

   Pool pool = new Pool(driver);

    @And("I tap Continue to play pool")
    public void iTapContinueToPlayPool() {
        pool.tapOnContinueBtn();
        sleep(700);
    }

}

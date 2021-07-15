package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.Dart;
import io.cucumber.java.en.And;

public class DartGameSteps extends TestBase {

    Dart dart = new Dart(driver);

    @And("I tap Continue to play Dart")
    public void iTapToContinueToPlayDart() {
        dart.tapOnContinueBtn();
    }
}

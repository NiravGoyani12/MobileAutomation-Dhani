package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.PaperFlick;
import io.cucumber.java.en.And;

public class PaperFlickSteps extends TestBase {

    PaperFlick paperFlick = new PaperFlick(driver);

    @And("I tap on Play button to start Paper Flick game")
    public void iTapOnPlayButtonToStartPaperFlickGame() {
        paperFlick.tapStartBtn();
        sleep(700);
    }

    @And("I tap to start")
    public void iTapToStart() {
        paperFlick.tapScreenToStart();
    }
}

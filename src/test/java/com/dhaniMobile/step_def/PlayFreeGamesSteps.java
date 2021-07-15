package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.nativeCards.PlayCardScreen;
import io.cucumber.java.en.And;

public class PlayFreeGamesSteps extends TestBase {

    PlayCardScreen playCardScreen = new PlayCardScreen(driver);

    @And("I click on the {string} game")
    public void iClickTheGame(String game) {
         playCardScreen.clickOnGame(game);
    }
}

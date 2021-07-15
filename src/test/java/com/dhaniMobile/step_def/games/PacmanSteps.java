package com.dhaniMobile.step_def.games;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.games.Pacman;
import io.cucumber.java.en.And;

public class PacmanSteps extends TestBase {

    Pacman pacman = new Pacman(driver);

    @And("I tap Play button to go to Pacman")
    public void iTapPlayButtonToGoToPacman() {
        pacman.tapPlayBtn();
    }

    @And("I tap on the next screen to start playing Pacman")
    public void iTapOnTheNextScreenToStartPlayingPacman() {
        pacman.tapToStart();
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.ServicesScreen;
import io.cucumber.java.en.When;

public class ServicesSteps extends TestBase {

    ServicesScreen servicesScreen = new ServicesScreen(driver);

    @When("I click on {string} service tile")
    public void iClickOnServiceTile(String service) {
        servicesScreen.clickOnService(service);
        sleep(5000);
    }
}

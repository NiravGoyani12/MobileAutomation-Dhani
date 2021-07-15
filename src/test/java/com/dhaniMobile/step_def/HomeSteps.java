package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.HomeScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HomeSteps extends TestBase {

    HomeScreen home = new HomeScreen(driver);

    @When("^I click on the native \"([^\"]*)\" card$")
    public void click_on_native_card(String cardName) {
        home.clickOnNativeCard(cardName);
        sleep(15000);
    }

    @When("^I click on the web \"([^\"]*)\" card$")
    public void iClickOnTheWebCard(String cardName) {
        home.clickOnWebCard(cardName);
        sleep(15000);
    }

    @Then("the Home button in the footer should be displayed")
    public void theHomeButtonInTheFooterShouldBeDisplayed() {
        assertThat(home.isHomeButtonDisplayed(), is(true));
    }

    @When("I click on Notification Bell")
    public void iClickOnNotificationBell() {
        home.clickOnNotificationBell();

    }

    @Then("the App Inbox should be displayed")
    public void theAppInboxShouldBeDisplayed() {
        assertThat(home.isAppInboxDisplayed(), is(true));
    }

    @When("I click on Support Icon")
    public void iClickOnSupportIcon() {
        home.clickOnSupportIcon();
    }

    @When("^I click on \"([^\"]*)\" on the footer$")
    public void iClickOnOnThFooter(String footerBtn) {
        home.clickOnFooterBtn(footerBtn);
        sleep(3000);
    }

    @When("^I click \"([^\"]*)\" label on home screen$")
    public void iClickLabelOnHomeScreen(String label) {
        home.clickOnLabel(label);
        sleep(6000);
    }
}

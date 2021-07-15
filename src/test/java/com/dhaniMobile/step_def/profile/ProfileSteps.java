package com.dhaniMobile.step_def.profile;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.profile.OtherBankCardsScreen;
import com.dhaniMobile.screens.profile.ProfileScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfileSteps extends TestBase {

    ProfileScreen profileScreen = new ProfileScreen(driver);
    OtherBankCardsScreen otherBankCardsScreen = new OtherBankCardsScreen(driver);

    @And("I click Log Out")
    public void iClickLogOut() {
          profileScreen.clickLogout();
    }

    @Then("the Profile page should be displayed")
    public void theProfilePageShouldBeDisplayed() {
        assertThat(profileScreen.IsDisplayed(), is(true));
    }

    @And("I click Yes in the Confirmation popup")
    public void iClickYesInTheConfirmationPopup() {
        profileScreen.ClickYesInConfirmationPopup();
    }

    @When("I tap Set Transaction Limit")
    public void iTapSetTransactionLimit() {
        profileScreen.tapSetTransactionLimit();
    }

    @And("I click {string} label on profile screen")
    public void iClickLinkOnProfileScreen(String label) {
        profileScreen.clickOnLabel(label);
    }

    @When("I tab 'Add photo' icon")
    public void iTabAddPhotoIcon() {
        profileScreen.clickToAddPhoto();
    }

    @Then("the Set up your Free Cashback Card screen should be opened")
    public void theScreenShouldBeOpened() {
        assertThat(profileScreen.isFCCScreenDisplayed(), is(true));
    }

    @Then("the Other Bank Cards screen should be displayed")
    public void theOtherBankCardsScreenShouldBeDisplayed() {
        assertThat(otherBankCardsScreen.isDisplayed(), is(true));
    }

    @Then("the General Wallet Statement screen should be displayed")
    public void theGeneralWalletStatementScreenShouldBeDisplayed() {
        assertThat(profileScreen.isGeneralWalletStatementScreenDisplayed(), is(true));
    }
}

package com.dhaniMobile.step_def;

import com.dhaniMobile.base.TestBase;
import com.dhaniMobile.screens.LoginScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps extends TestBase {

    LoginScreen login = new LoginScreen(driver);
    private String _userType;

    @When("^I enter my mobile number \"([^\"]*)\"$")
    public void i_enter_my_mobile_number(String mobileNumber) throws MalformedURLException {
        login.enterMobileNumber(mobileNumber);
    }

    @When("^I enter the mobile number of \"([^\"]*)\" user$")
    public void i_enter_mobile_number_of_user(String userType) throws MalformedURLException {
        _userType = userType;
        String mobileNumber = login.getMobileNumber(userType);
        login.enterMobileNumber(mobileNumber);
    }

    @When("^I tap on next to continue$")
    public void i_tap_on_next_to_continue() throws MalformedURLException {
        login.tapOnNextButton();

    }

    @When("^I enter my password \"([^\"]*)\"$")
    public void i_enter_my_password(String password) throws MalformedURLException {
        login.enterPassword(password);
    }

    @And("I enter my password")
    public void iEnterMyPassword() throws MalformedURLException {
        String password = login.getPassword(_userType);
        login.enterPassword(password);
    }

    @When("^I tap to continue$")
    public void i_tap_to_continue() throws MalformedURLException {
        login.tapOnContinueButton();

    }

    @When("^I close the 'Offer of the day' pop up if it is displayed$")
    public void close_Offer_Of_Day_Popup() throws MalformedURLException {

        //    The Offer of the Day popup is removed in Production
        //    Let's keep the step disabled in case we will need it again in the future

        // The popup is displayed only sometimes.
        // Therefore we need to close it
        // only if it is displayed

//        if(login.IsOfferOfDayPopupDisplayed())
//        {
//            login.closeOfferOfDayPopup();
//        }
    }

    @Given("^I am logged in with mobile number \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_am_logged_in_with_mobile_number_and_password(String mobileNumber, String password) throws MalformedURLException {
        login.clickStartNow();
        login.enterMobileNumber(mobileNumber);
        login.tapOnNextButton();
        login.enterPassword(password);
        login.tapOnContinueButton();
        if (login.isRegisterPageDisplayed()) {
            // we don't want to register now
            login.clickSkipRegistrationButton();
        }

    }

    @Given("I click Start Now")
    public void clickStartNow() {
        login.clickStartNow();
    }

    @And("I click the Skip button on the Register page if it is displayed")
    public void iClickTheSkipButtonIfItIsDisplayed() {
        if (login.isRegisterPageDisplayed()) {
            // we don't want to register now
            login.clickSkipRegistrationButton();
        }

    }

    @When("I click Need Help")
    public void iClickNeedHelp() {
        login.clickNeedHelp();
    }

    @Then("the text {string} should be displayed")
    public void thePopupWithTheTextShouldBeDisplayed(String expText) {
         assertThat(login.getCallUsNowText(), containsString(expText));
    }

    @When("I click Forgot Password")
    public void iClickForgotPassword() {
        login.clickForgotPassword();
    }

    @Then("the OTP Authentication page should be displayed")
    public void theOTPAuthenticationPageShouldBeDisplayed() {
        login.waitUntilOTPAuthenticationPageIsDisplayed();
    }

    @Then("the OTP Authentication page or 'You have crossed the maximum number of OTP retry allowed' text should be displayed")
    public void theOTPAuthenticationPageOrYouHaveCrossedTheMaximumNumberOfOTPRetryAllowedTextShouldBeDisplayed() {
        try {
            login.waitUntilOTPAuthenticationPageIsDisplayed();
        }
        catch(Exception e) {
            login.waitForTextAboutExceedingMaximumOtpRetries();
        }
    }

    @Then("the Password page should be displayed")
    public void thePasswordPageShouldBeDisplayed() {
        login.waitForPasswordPage();
    }

    @When("I click on the 'Log in as different user' link")
    public void iClickOnTheLogInAsDifferentUserLink() {
        login.clickLoginAsDifferentUserLink();
    }

    @When("I click on 'Offer Of Day - Claim Now'")
    public void iClickOnOfferOfDayClaimNow() {
        login.clickOfferOfDayClaimNow();
        sleep(20000);
    }

    @Given("I am logged in as {string} user")
    public void iAmLoggedInAsUser(String userType) throws MalformedURLException {

        String mobileNumber = login.getMobileNumber(userType);
        String password = login.getPassword(userType);

        login.clickStartNow();
        login.enterMobileNumber(mobileNumber);
        login.tapOnNextButton();
        login.enterPassword(password);
        login.tapOnContinueButton();
        if (login.isRegisterPageDisplayed()) {
            // we don't want to register now
            login.clickSkipRegistrationButton();
        }
    }

    @Then("the 'Terms & Conditions' link should be displayed")
    public void theTermsConditionsLinkShouldBeDisplayed() {
        assertThat(login.isTermConditionLinkDisplayed(), is(true));
    }
}

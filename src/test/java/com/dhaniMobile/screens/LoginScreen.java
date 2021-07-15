package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

import static com.dhaniMobile.base.TestBase.sleep;
import static com.dhaniMobile.utilities.CommonUtils.*;

public class LoginScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/enter_mobile_number_edit_text")
    public WebElement mobileInputField;

    @AndroidFindBy(className = "android.widget.Button")
    public WebElement nextButton;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement passwordInputField;

    @AndroidFindBy(id = "com.indiaBulls:id/btnNext")
    public WebElement continueButton;

    @AndroidFindBy(id = "com.indiaBulls:id/scratch_card_cancel")
    public WebElement offerOfDayPopupCloseButton;

    @AndroidFindBy(id = "com.indiaBulls:id/get_started")
    public WebElement startNowBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/btnSignup")
    private WebElement registerBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/tvSkipStep")
    private WebElement skipRegistrationBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/txtVwNeedHelp")
    private WebElement needHelpBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/tvHelpTitle")
    private WebElement helpTitle;

    @AndroidFindBy(id = "com.indiaBulls:id/txtVwResend")
    private WebElement forgotPasswordLink;

    @AndroidFindBy(id = "com.indiaBulls:id/tvOtpAuth")
    private WebElement OTPAuthenticationPage;

    @AndroidFindBy(id = "com.indiaBulls:id/message_txt_vw")
    private WebElement textAboutExceedingMaximumOtpRetries;

    @AndroidFindBy(id = "com.indiaBulls:id/txtVwDifferentUser")
    private WebElement loginAsDifferentUserLink;

    @AndroidFindBy(id = "com.indiaBulls:id/scratch_card_redeem")
    private WebElement claimNowOfferOfDayBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/txtTnc")
    public WebElement termsConditionLink;

    public void enterMobileNumber(String mobileNumber) throws MalformedURLException {
        testBase.waitForElementVisibility(mobileInputField, 5, "mobile input field is not visible");
        mobileInputField.sendKeys(mobileNumber);
    }

    public void tapOnNextButton() throws MalformedURLException {
        nextButton.click();
        sleep(1500);
    }

    public void enterPassword(String password) throws MalformedURLException {
        passwordInputField.sendKeys(password);

    }

    public void tapOnContinueButton() throws MalformedURLException {
        continueButton.click();
        sleep(5000);
        
    }

    public void closeOfferOfDayPopup() throws MalformedURLException {
        offerOfDayPopupCloseButton.click();
        sleep(500);

    }

    public Boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }

    public boolean IsOfferOfDayPopupDisplayed() {

        sleep(5000);

        try {
            return offerOfDayPopupCloseButton.isDisplayed();
        }
        catch(Exception e) {
            return false;
        }
    }

    public void clickStartNow() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(startNowBtn, 7, "Start Now button is not visible");
        startNowBtn.click();
    }

    public boolean isRegisterPageDisplayed() {
        sleep(3000);

        try {
            return registerBtn.isDisplayed();
        }
        catch(Exception e) {
            return false;
        }

    }

    public void clickSkipRegistrationButton() {
        skipRegistrationBtn.click();
    }

    public void clickNeedHelp() {
        needHelpBtn.click();
    }

    public String getCallUsNowText() {
        testBase.waitForElementVisibility(helpTitle, 5, "Help title is not displayed");
        return helpTitle.getText();
    }

    public void clickForgotPassword() {
        testBase.waitForElementVisibility(forgotPasswordLink, 5, "Forgot password link is not displayed");
        forgotPasswordLink.click();
    }

    public void waitUntilOTPAuthenticationPageIsDisplayed() {
        testBase.waitForElementVisibility(OTPAuthenticationPage, 15, "OTP Authentication page is not displayed");
    }

    public void waitForTextAboutExceedingMaximumOtpRetries() {

        if (OTPAuthenticationPage.isDisplayed()) return; // if we have this OTP page, we don't need to wait for the message below

        testBase.waitForElementVisibility(textAboutExceedingMaximumOtpRetries, 5, "Text about exceeding Maximum OTP Retries is not displayed");
    }

    public void waitForPasswordPage() {
        testBase.waitForElementVisibility(passwordInputField, 5, "Password page is not displayed");
    }

    public void clickLoginAsDifferentUserLink() {
        testBase.waitForElementVisibility(loginAsDifferentUserLink, 5, "Text about exceeding Maximum OTP Retries is not displayed");
        loginAsDifferentUserLink.click();

    }

    public void clickOfferOfDayClaimNow() {
        if(IsOfferOfDayPopupDisplayed())
        {
            claimNowOfferOfDayBtn.click();
        }
    }

    public String getMobileNumber(String userType) {

        switch(userType) {
            case "No KYC":
                return NO_KYC_USER_PHONE;
            case "Min KYC":
                return MIN_KYC_USER_PHONE;
            case "Full KYC":
                return FULL_KYC_USER_PHONE;
            case "with card":
                return USER_WITH_CARD_PHONE;
            case "New User":
                return NEW_USER;
            case "SS Active User":
                return SS_ACTIVE_USER_PHONE;
            case "SS Inactive User":
                return SS_INACTIVE_USER_PHONE;
            case "Add Bank Money User":
                return ADD_BANK_MONEY_USER_PHONE;
            case "Transfer Money User":
                return TRANSFER_MONEY_USER_PHONE;
            case "Existing Active User without Card":
                return EXISTING_ACTIVE_WITHOUT_CARD_USER;
            case "Existing Active User with Card":
                return EXISTING_ACTIVE_WITH_CARD_USER;
            default:
                throw new IllegalStateException("Unexpected user type: " + userType);
        }
    }

    public String getPassword(String userType) {

        switch(userType) {
            case "No KYC":
                return NO_KYC_USER_PSW;
            case "Min KYC":
                return MIN_KYC_USER_PSW;
            case "Full KYC":
                return FULL_KYC_USER_PSW;
            case "with card":
                return USER_WITH_CARD_PSW;
            case "SS Active User":
                return SS_ACTIVE_USER_PASSWORD;
            case "SS Inactive User":
                return SS_INACTIVE_USER_PASSWORD;
            case "Add Bank Money User":
                return ADD_BANK_MONEY_USER_PASSWORD;
            case "Transfer Money User":
                return TRANSFER_MONEY_USER_PASSWORD;
            case "Existing Active User without Card":
                return EXISTING_ACTIVE_WITHOUT_CARD_USER_PASSWORD;
            case "Existing Active User with Card":
                return EXISTING_ACTIVE_WITH_CARD_USER_PASSWORD;
            default:
                throw new IllegalStateException("Unexpected user type: " + userType);
        }
    }

    public Boolean isTermConditionLinkDisplayed() {
        testBase.getNativeView();
        testBase.waitForElementVisibility(termsConditionLink, 5, "Term and Condition is not visible");
        return termsConditionLink.isDisplayed();
    }
}

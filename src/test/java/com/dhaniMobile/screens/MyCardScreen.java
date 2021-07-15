package com.dhaniMobile.screens;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class MyCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public MyCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.indiaBulls:id/tvSubTitle")
    private WebElement noKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTitle")
    private WebElement fullKycCardDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/tvNumber")
    private WebElement cardNumberField;

    @AndroidFindBy(id = "com.indiaBulls:id/clLostCard")
    private WebElement lostCardBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTitle")
    private WebElement lostCardPopupTitle;

    @AndroidFindBy(id = "com.indiaBulls:id/showcase_button")
    private WebElement demoNextBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/clResetTransaction")
    private WebElement resetTransactionPINBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTransactionText")
    private WebElement transactionsHeader;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTransactionTitle")
    private WebElement transactionTitle;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTransactionDate")
    private WebElement transactionDate;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTransactionAmount")
    private WebElement transactionAmount;

    @AndroidFindBy(id = "com.indiaBulls:id/tvTransactionDetails")
    private WebElement transactionDetails;

    @AndroidFindBy(id = "com.indiaBulls:id/clSuperSaver")
    private WebElement activateSupersaverBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/clSetTransactionLimit")
    private WebElement setTransactionLimitBtn;

    @FindBy(xpath = "/html/body/app-root/app-cashback-page/div[1]")
    ///html/body/app-root/app-cashback-page/div[1]
    private WebElement supersaverScreenHeader;

    @FindBy(css = ".mb-20.mat-button")
    private WebElement continueBtnOnSupersaverScreen;

    @FindBy(xpath = "/html/body/app-root/app-subscription-plans-page/app-plan-card[1]/mat-card/button")
    private WebElement buyNowBtnOnSupersaverScreen;

    @FindBy(xpath = "/html/body/app-root/app-subscription-charges-page/div[2]/div[3]/div[2]")
    private WebElement supportedBanksSectionOnSupersaverScreen;

    @AndroidFindBy(id = "com.indiaBulls:id/ivActivateNewDigitalCard")
    private WebElement activateNewDigitalCardBtn;

    @AndroidFindBy(id = "com.indiaBulls:id/etCode")
    private WebElement pinInput;

    @AndroidFindBy(id = "com.indiaBulls:id/tvContinue")
    private WebElement continueBtn;

    public String getCardDescription(String userType) {

        testBase.getNativeView();
        switch(userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycCardDescription, 7, "text is not displayed");
                return noKycCardDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycCardDescription, 10, "text is not displayed");
                return fullKycCardDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }

    public boolean isCardWithNumberDisplayed(String cardNumber) {
        return cardNumberField.isDisplayed() && cardNumberField.getText().equals(cardNumber);
    }

    public void tapLostCard() {
        lostCardBtn.click();
    }

    public boolean isConfirmationPopupDisplayed(String text) {
        return lostCardPopupTitle.getText().contains(text);
    }

    // There are a few steps of a demo after we tap My Card button.
    // On each step we need to tap the Next button. Finally we tap the Got It button.
    // And the demo disappears.
    public void goThroughDemo() {
        demoNextBtn.click();
        testBase.sleep(1000);
        demoNextBtn.click();
        testBase.sleep(1000);
        demoNextBtn.click();
        testBase.sleep(1000);
        demoNextBtn.click();
        testBase.sleep(1000);
    }

    public void tapResetTransactionPin() {
        resetTransactionPINBtn.click();
    }

    public boolean isTransactionsHeaderDisplayed() {
        // scroll to the bottom (VIEW ALL link) to see all transactions details
        testBase.scrollIntoView("VIEW ALL");
        return transactionsHeader.isDisplayed();
    }

    public boolean isTransactionTitleDisplayed() {
        return transactionTitle.isDisplayed();
    }

    public boolean isTransactionDateDisplayed() {
        return transactionDate.isDisplayed();
    }

    public boolean isTransactionAmountDisplayed() {
        return transactionAmount.isDisplayed();
    }

    public boolean isTransactionDetailsDisplayed() {
        return transactionDetails.isDisplayed();
    }

    public void tapActivateSuperSaver() {
        testBase.scrollIntoView("Activate Supersaver for 5% Cashback on all transactions");
        activateSupersaverBtn.click();
    }

    public boolean isSupersaverScreenDisplayed() {
        testBase.sleep(5000);
        testBase.getWebView();
        return supersaverScreenHeader.isDisplayed();
    }

    public void tapContinueOnSupersaverDetailsScreen() {
        testBase.getWebView();
        testBase.scrollIntoViewSelenium(continueBtnOnSupersaverScreen);
        continueBtnOnSupersaverScreen.click();
    }

    public boolean isChooseYourPlanScreenDisplayed() {
        testBase.sleep(5000);
        testBase.getWebView();
        return buyNowBtnOnSupersaverScreen.isDisplayed();
    }

    public void tapBuyNowOnChooseYourPlanScreen() {
        testBase.sleep(5000);
        testBase.getWebView();
        buyNowBtnOnSupersaverScreen.click();
    }

    public boolean isSupportedBanksSectionDisplayed() {
        testBase.sleep(3000);
        testBase.getWebView();
        return supportedBanksSectionOnSupersaverScreen.isDisplayed();
    }

    public void tapSetTransactionLimit() {
        setTransactionLimitBtn.click();
    }

    public void tapActivateNewDigitalCard() {
        activateNewDigitalCardBtn.click();
    }

    public boolean isActivateNewDigitalCardBtnDisplayed() {
        return activateNewDigitalCardBtn.isDisplayed();
    }

    public void enterPin(String pin) {
        pinInput.sendKeys(pin);
        continueBtn.click();
        testBase.sleep(2000);
    }
}

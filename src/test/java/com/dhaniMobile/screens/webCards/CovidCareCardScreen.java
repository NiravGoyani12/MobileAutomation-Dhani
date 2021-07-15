package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CovidCareCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public CovidCareCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "/html/body/app-root/div/app-user-flow/div/app-health-bag/div/div[1]/div/button/span")
    public WebElement cardDescription;

    @FindBy(xpath="//div/app-health-bag-title/div/div/div/h2")
    public WebElement orderConfirmationMessage;

    @FindBy(xpath="//app-payment-popup-v2/div/div[1]/div/div[2]/label")
    public WebElement paymentConfirmationPage;

    @FindBy(xpath="//app-health-bag/div/div[2]/button")
    public WebElement orderNowButton;

    @FindBy(xpath="//app-add-address/div/form/div/button")
    public WebElement nextButton;

    @FindBy(xpath="//app-payment-popup-v2/div/div[2]/button")
    public WebElement payButton;

    @FindBy(xpath="//android.webkit.WebView/android.view.View[2]/android.view.View[2]/android.view.View/android.app.Dialog/android.view.View[2]/android.view.View[6]")
    public WebElement saveYourCardForFastPay;


    @FindBy(xpath="//html/body/app-root/div/app-pay-page/div[3]/div/button/span/span/span[1]")
    public WebElement creditCardDetails;

    @FindBy(xpath="//html/body/app-root/div/app-pay-page/div[4]/div/button/span/span/span[1]")
    public WebElement debitCardDetails;

    @FindBy(xpath="//html/body/app-root/div/app-pay-page/div[5]/div/div[2]/button/span/span")
    public WebElement upiDetails;

    @FindBy(xpath="//html/body/app-root/div/app-pay-page/div[6]/div/div[2]/button[4]/span/img")
    public WebElement netBankingSBI;

    @AndroidFindBy(xpath="//android.app.Dialog/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public WebElement creditCardNumber;

    @AndroidFindBy(xpath="//android.app.Dialog/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public WebElement creditCardValidity;

    @AndroidFindBy(xpath="//android.app.Dialog/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public WebElement creditCardCVV;

    @AndroidFindBy(xpath="//android.app.Dialog/android.view.View[2]/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public WebElement creditCardName;

    @AndroidFindBy(xpath="//android.app.Dialog/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")
    public WebElement creditCardTitle;

    @FindBy(xpath="//*[@id=\"cdk-overlay-1\"]/mat-bottom-sheet-container/app-credit-debit-cards-sheet/form/button")
    public WebElement creditCardPayButton;

    @FindBy(xpath="//*[@id=\"btn\"]")
    public WebElement paymentConfirmationButton;

    @FindBy(xpath="//html/body/form/button[1]")     //Success
    public WebElement successConfirmationMessage;


    public String getCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardDescription, 15, "Card description is not visible");
        return cardDescription.getText();
    }

    public String getDisplayedOrderConfirmationDetails() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(orderConfirmationMessage, 15, "Order Confirmation Text is not visible");
        return orderConfirmationMessage.getText();
    }

    public void clickOnOrderNowButton() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.scrollIntoViewSelenium(orderNowButton);
        testBase.waitForElementVisibility(orderNowButton, 15, "Order Now Button is not visible");
        orderNowButton.click();
    }

    public void clickOnNextButton() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(nextButton, 15, "Next Button is not visible");
        nextButton.click();
    }

    public String getDisplayedPaymentConfirmationDetails() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(paymentConfirmationPage, 15, "Net Payable Amount banner is not visible");
        return paymentConfirmationPage.getText();
    }

    public void clickOnPayButton() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(payButton, 15, "PayButton is not visible");
        payButton.click();
    }

    public void selectPaymentMethodAsCreditCard() {
        testBase.sleep(5000);
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(creditCardDetails, 15, "PayButton is not visible");
        creditCardDetails.click();
    }

    public void enterCreditCardDetails() {

        testBase.sleep(5000);
        testBase.getNativeView();
        testBase.waitForElementVisibility(creditCardNumber, 15, "Credit Card Number is not visible");
        creditCardNumber.sendKeys("4012001037141112");

        testBase.getNativeView();
        testBase.waitForElementVisibility(creditCardValidity, 15, "Credit Card Validity is not visible");
        creditCardValidity.sendKeys("12/25");

        testBase.waitForElementVisibility(creditCardCVV, 15, "Credit Card CVV is not visible");
        creditCardCVV.sendKeys("123");

//        testBase.waitForElementVisibility(creditCardName, 15, "Credit Card Name is not visible");
        creditCardName.sendKeys("My HDFC Card");

//        testBase.waitForElementVisibility(creditCardTitle, 15, "Credit Card Title is not visible");
        creditCardTitle.sendKeys("HDFC Credit Card");

//        testBase.waitForElementVisibility(saveYourCardForFastPay, 15, "Save your Card for Fast Pay is not visible");
        saveYourCardForFastPay.click();



    }

    public void shouldseeOrderSuccessfulMessage() {
    }


    public void payByCreditCardButton() {
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(creditCardPayButton, 15, "Credit Card Payment Button is not visible");
        creditCardPayButton.click();
    }
}

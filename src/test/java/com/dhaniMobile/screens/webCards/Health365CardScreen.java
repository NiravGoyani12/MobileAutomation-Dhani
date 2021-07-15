package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.dhaniMobile.base.TestBase.sleep;

public class Health365CardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public Health365CardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-h365-new-user-video-popup/div/button")
    public WebElement health365CardPopupCloseBtn;
    
    @FindBy(xpath = "//app-plan-selector-card[1]/div/mat-card/mat-card-header/div[2]/mat-card-subtitle")
    public WebElement cardDescription;

    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    public WebElement health365PinCodeInputField;

    @FindBy(xpath = "//*[@id=\"mat-dialog-1\"]/app-pincode-check/div/form/div/button[1]")
    public WebElement health365PinSubmitButton;


    public void closeHealthCardAdvertisePopup(){
        testBase.sleep(3000);
        testBase.getNativeView();
        testBase.getWebView();

        testBase.waitForElementVisibility(health365CardPopupCloseBtn, 15, "Advertisement popup is not visible");
        health365CardPopupCloseBtn.click();
    }

    public void enterPinCodeOnHealthCard(String pinCode){
        driver.context("WEBVIEW_com.indiaBulls");
        testBase.waitForElementVisibility(health365PinCodeInputField, 7, "Enter Pincode field is not visible");
        health365PinCodeInputField.sendKeys(pinCode);
        sleep(1000);
        testBase.waitForElementVisibility(health365PinSubmitButton, 7, "Confirm button is not enabled");
        health365PinSubmitButton.click();
    }
    
    public String getCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardDescription, 15, "Card description is not visible");
        return cardDescription.getText();
    }
}

package com.dhaniMobile.screens.webCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StocksCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();
    public StocksCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(css = ".LoginWelcomeTxt-textline")
    public WebElement cardDescription;

    @FindBy(css = "")
    public WebElement openNewStockBtn;

    @FindBy(css = "")
    public WebElement backArrow;

    @FindBy(css = "")
    public WebElement okayAlertBtn;

    @FindBy(css = "")
    public WebElement welcomeTextStockLabel;

    public String getCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(cardDescription, 5, "Card description is not visible");
        return cardDescription.getText();

    }

    public void clickOnOpenNewAccount() {
        testBase.waitForElementVisibility(cardDescription, 5, "open new acount button is not visible");
        openNewStockBtn.click();
    }

    public void clickOnBackArrowOnStock() {
        testBase.waitForElementVisibility(cardDescription, 5, "back arrow is not visible");
        backArrow.click();
    }

    public void clickOnOkayAlert() {
        testBase.waitForElementVisibility(cardDescription, 5, "okay alert button is not visible");
        okayAlertBtn.click();
    }

    public String getWelcomeTextStock() {
        testBase.getWebView();
        testBase.waitForElementVisibility(welcomeTextStockLabel, 5, "welcome to dhani stock msg is not visible");
        return welcomeTextStockLabel.getText();
    }
}

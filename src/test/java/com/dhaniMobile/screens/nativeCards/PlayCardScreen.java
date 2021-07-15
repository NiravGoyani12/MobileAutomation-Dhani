package com.dhaniMobile.screens.nativeCards;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PlayCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public PlayCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Earn Rewards']")
    public WebElement cardDescriptionNoKyc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dhani Cash Balance']")
    public WebElement cardDescriptionFullKyc;

    public String getNoKycCardDescription(){
        return cardDescriptionNoKyc.getText();
    }

    public String getFullKycCardDescription(){
        testBase.scrollIntoView("Dhani Cash Balance");
        return cardDescriptionFullKyc.getText();
    }

    public void clickOnGame(String game) {
        testBase.getNativeView();
        String gameLocator = "//android.widget.TextView[@text='"+ game +"']";
        driver.findElementByXPath(gameLocator).click();
        testBase.sleep(5000);
    }
}

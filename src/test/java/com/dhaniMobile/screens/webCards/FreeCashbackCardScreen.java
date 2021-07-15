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

public class FreeCashbackCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public FreeCashbackCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(css = ".header-title")
    public WebElement NoKyccardDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Card']")
    public WebElement fullKycCardDescription;

    public String getNoKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(NoKyccardDescription, 15, "Card description is not visible");
        return NoKyccardDescription.getText();
    }

    public String getFullKycCardDescription(){
        testBase.getNativeView();
        testBase.waitForElementVisibility(fullKycCardDescription, 5, "Card description is not visible");
        return fullKycCardDescription.getText();
    }
}

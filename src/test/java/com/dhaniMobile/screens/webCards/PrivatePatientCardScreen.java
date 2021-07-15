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

public class PrivatePatientCardScreen extends ScreenBase {

    TestBase testBase = new TestBase();
    public PrivatePatientCardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycCardDescription;

    @FindBy(css = ".headSpan")
    public WebElement fullKyccardDescription;

    public String getNoKycCardDescription(){
        testBase.getNativeView();
        testBase.waitForElementVisibility(noKycCardDescription, 5, "Card description is not visible");
        return noKycCardDescription.getText();

    }

    public String getFullKycCardDescription(){
        testBase.getNativeView();
        testBase.getWebView();
        testBase.waitForElementVisibility(fullKyccardDescription, 15, "Card description is not visible");
        return fullKyccardDescription.getText();

    }
}

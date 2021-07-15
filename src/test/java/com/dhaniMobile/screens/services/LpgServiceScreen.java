package com.dhaniMobile.screens.services;

import com.dhaniMobile.base.ScreenBase;
import com.dhaniMobile.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LpgServiceScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public LpgServiceScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycLpgTileDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/edtTxtOperator")
    public WebElement fullKycLpgTileDescription;

    public String getLpgCardDescription(String userType) {

        testBase.getNativeView();

        switch (userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycLpgTileDescription, 7, "text is not displayed");
                return noKycLpgTileDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycLpgTileDescription, 10, "text is not displayed");
                return fullKycLpgTileDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }
}

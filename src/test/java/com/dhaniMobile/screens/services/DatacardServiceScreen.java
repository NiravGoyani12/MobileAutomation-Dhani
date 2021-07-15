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

public class DatacardServiceScreen extends ScreenBase {

    TestBase testBase = new TestBase();

    public DatacardServiceScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Set up your Free Cashback Card to continue']")
    public WebElement noKycDatacardTileDescription;

    @AndroidFindBy(id = "com.indiaBulls:id/edtTxtOperator")
    public WebElement fullKycDatacardTileDescription;

    public String getDatacardCardDescription(String userType) {

        testBase.getNativeView();

        switch (userType.toLowerCase(Locale.ROOT)) {
            case "no kyc":
                testBase.waitForElementVisibility(noKycDatacardTileDescription, 7, "text is not displayed");
                return noKycDatacardTileDescription.getText();
            case "full kyc":
                testBase.waitForElementVisibility(fullKycDatacardTileDescription, 10, "text is not displayed");
                return fullKycDatacardTileDescription.getText();
            default:
                throw new IllegalStateException("Unexpected card name: " + userType.toLowerCase(Locale.ROOT));
        }
    }
}
